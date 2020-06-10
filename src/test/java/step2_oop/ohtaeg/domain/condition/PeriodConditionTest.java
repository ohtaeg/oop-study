package step2_oop.ohtaeg.domain.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2_oop.ohtaeg.domain.Screening;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

class PeriodConditionTest {

    @Test
    @DisplayName("PeriodCondition 생성을 성공한다.")
    void create() {
        PeriodCondition expect = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59));

        PeriodCondition actual = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59));

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("할인이 가능한 시간인지에 대해 비교를 성공한다.")
    void isSatisfiedBy() {
        Screening screening = new Screening(null, 0, LocalDateTime.of(2020, Month.JUNE, 8, 11, 0));

        PeriodCondition actual = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59));

        assertThat(actual.isSatisfiedBy(screening)).isTrue();
    }

}