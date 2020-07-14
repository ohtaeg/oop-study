package practice.signup.domain;

import practice.signup.exception.InvalidIdException;
import practice.signup.util.StringUtils;

import java.util.Objects;

public class Id {
    private final String value;

    public Id(final String value) {
        validateEmpty(value);
        this.value = value;
    }

    private void validateEmpty(final String value) {
        if (StringUtils.isEmpty(value)) {
            throw new InvalidIdException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Id id = (Id) o;
        return Objects.equals(value, id.value);
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
