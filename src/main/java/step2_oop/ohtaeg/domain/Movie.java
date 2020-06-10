package step2_oop.ohtaeg.domain;

import step2_oop.ohtaeg.domain.policy.DiscountPolicy;

import java.time.Duration;
import java.util.Objects;

public class Movie {
    private final String title;
    private final Duration runningTime;
    private final Money fee;
    private final DiscountPolicy discountPolicy;

    public Movie(final String title, final Duration runningTime, final Money fee, final DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(runningTime, movie.runningTime) &&
                Objects.equals(fee, movie.fee) &&
                Objects.equals(discountPolicy, movie.discountPolicy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, runningTime, fee, discountPolicy);
    }
}
