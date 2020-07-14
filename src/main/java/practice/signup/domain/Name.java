package practice.signup.domain;

import practice.signup.exception.InvalidNameException;
import practice.signup.util.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {
    private static final Pattern PATTERN = Pattern.compile("^[가-힣]{2,4}$");

    private final String value;

    public Name(final String value) {
        validateName(value);
        validateFormat(value);
        this.value = value;
    }

    private void validateName(final String value) {
        if (StringUtils.isEmpty(value)) {
            throw new InvalidNameException();
        }
    }

    private void validateFormat(final String value) {
        if (!PATTERN.matcher(value).matches()) {
            throw new InvalidNameException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name = (Name) o;
        return Objects.equals(value, name.value);
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
