package step2_oop.ohtaeg.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    @DisplayName("Money 객체 생성을 성공한다.")
    void create() {
        Money expect = Money.wons(1000);

        Money actual = Money.wons(1000);

        assertThat(actual).isEqualTo(expect);
    }

}