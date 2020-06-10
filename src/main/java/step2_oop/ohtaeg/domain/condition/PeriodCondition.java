package step2_oop.ohtaeg.domain.condition;

import step2_oop.ohtaeg.domain.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public class PeriodCondition implements DiscountCondition {
    private final DayOfWeek dayOfWeek;
    private final LocalTime start;
    private final LocalTime end;

    public PeriodCondition(final DayOfWeek dayOfWeek, final LocalTime start, final LocalTime end) {
        this.dayOfWeek = dayOfWeek;
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean isSatisfiedBy(final Screening screening) {
        return isSameDayOfWeek(screening) && isSameStartTime(screening) && isSameEndTime(screening);
    }

    private boolean isSameDayOfWeek(final Screening screening) {
        return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek);
    }

    private boolean isSameStartTime(final Screening screening) {
        return start.compareTo(screening.getStartTime()) <= 0;
    }

    private boolean isSameEndTime(final Screening screening) {
        return end.compareTo(screening.getStartTime()) >= 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PeriodCondition that = (PeriodCondition) o;
        return dayOfWeek == that.dayOfWeek &&
                Objects.equals(start, that.start) &&
                Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfWeek, start, end);
    }
}
