package practice.signup.domain;

import practice.signup.util.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {
    private static final Pattern PATTERN = Pattern.compile("[\\w~\\-.+]+@[\\w~\\-]+(\\.[\\w~\\-]+)+");

    private final String address;

    public Email(String address) {
        validateEmpty(address);
        validAvailableAddress(address);

        this.address = address;
    }

    private void validateEmpty(final String address) {
        if (StringUtils.isEmpty(address)) {
            throw new IllegalArgumentException();
        }
    }

    private void validAvailableAddress(String address) {
        if (!PATTERN.matcher(address).matches()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Email email = (Email) o;
        return Objects.equals(address, email.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return address;
    }
}
