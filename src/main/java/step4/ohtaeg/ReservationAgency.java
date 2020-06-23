package step4.ohtaeg;

import step2_oop.ohtaeg.domain.Money;

/**
 * 현재 할인 정책을 선택하는 코드와 할인 조건을 판단하는 코드가 같이 있음
 */
public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();
        boolean discountable = false;

        // DiscountCondition or screening 데이터 변경시 ReservationAgency도 강제로 변경되어야함
        for (DiscountCondition condition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                // 할인 정책별로 할인 요금을 계산하는 방법이 변경될 경우 (낮은 응집도)
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek())
                        && condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0
                        && condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                discountable = condition.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }
        }
        Money fee;
        if (discountable) {
            Money discountAmount = Money.ZERO;
            // 할인 조건이 추가가 될 경우
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT :
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT :
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT :
                    discountAmount = Money.ZERO;
                    break;
            }
            // 계산 책임은 Movie 한테 있는데 ReservationAgency에서 수행중
            // 캡슐화 x, 객체 제어를 ReservationAgency에서 수행중
            fee = movie.getFee().minus(discountAmount).times(audienceCount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}