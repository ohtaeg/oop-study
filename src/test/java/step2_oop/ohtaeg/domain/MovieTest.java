package step2_oop.ohtaeg.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2_oop.ohtaeg.domain.condition.fake.TrueDiscountCondition;
import step2_oop.ohtaeg.domain.policy.AmountDiscountPolicy;
import step2_oop.ohtaeg.domain.policy.DiscountPolicy;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {
    private DiscountPolicy discountPolicy;

    @BeforeEach
    void setUp() {
        discountPolicy = new AmountDiscountPolicy(Money.ZERO, new TrueDiscountCondition());
    }

    @Test
    @DisplayName("Movie 객체 생성을 성공한다.")
    void create() {
        final String title = "test";
        final Duration runningTime = null;
        final Money fee = Money.ZERO;
        Movie expect = new Movie(title, runningTime, fee, discountPolicy);

        Movie actual = new Movie(title, runningTime, fee, discountPolicy);

        assertThat(actual).isEqualTo(expect);
    }

}