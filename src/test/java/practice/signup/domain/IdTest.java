package practice.signup.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.signup.exception.InvalidIdException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class IdTest {
    @Test
    @DisplayName("ID 객체를 생성할 수 있다.")
    void create() {
        Id expect = new Id("오태경");

        Id actual = new Id("오태경");

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("빈 값으로 객체 생성시 예외를 발생한다.")
    void validEmpty() {
        assertThatExceptionOfType(InvalidIdException.class).isThrownBy(
                () -> new Id(" ")
        );
    }
}
