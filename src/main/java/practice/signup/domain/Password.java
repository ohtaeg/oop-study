package practice.signup.domain;

import practice.signup.exception.InvalidPasswordException;
import practice.signup.util.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

public class Password {
    private static final Pattern PATTERN = Pattern.compile("/^.*(?=^.{8,16}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/");

    private final String value;

    public Password(final String value, final String reConfirmValue) {
        validEmpty(value);
        doubleCheck(value, reConfirmValue);
        this.value = value;
    }

    private void validEmpty(final String value) {
        if (StringUtils.isEmpty(value)) {
            throw new InvalidPasswordException();
        }
    }

    private void doubleCheck(final String value, final String reConfirmValue) {
        if (!value.equals(reConfirmValue)) {
            throw new InvalidPasswordException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Password password = (Password) o;
        return Objects.equals(value, password.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
