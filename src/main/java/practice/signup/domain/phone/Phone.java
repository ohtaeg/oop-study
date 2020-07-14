package practice.signup.domain.phone;

import practice.signup.domain.authentication.Authentication;
import practice.signup.util.StringUtils;

import java.util.Objects;

public class Phone {
    private final String number;

    public Phone(final String number, final String certificationNumber, final Authentication authentication) {
        validEmpty(number);
        if (!authentication.isSatisfied(certificationNumber)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    private void validEmpty(final String number) {
        if (StringUtils.isEmpty(number)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Phone phone = (Phone) o;
        return Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number;
    }
}
