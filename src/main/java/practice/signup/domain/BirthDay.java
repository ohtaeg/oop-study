package practice.signup.domain;

import practice.signup.util.StringUtils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class BirthDay {
    private static final String DELIMITER = "-";

    private final LocalDate value;

    public BirthDay(final String birthDay) {
        validEmpty(birthDay);
        this.value = convertDate(split(birthDay));
    }

    private void validEmpty(final String birthDay) {
        if (StringUtils.isEmpty(birthDay)) {
            throw new IllegalArgumentException();
        }
    }

    private int[] split(final String birthDay) {
        String[] spliced = birthDay.split(DELIMITER);
        if (spliced.length != 3) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(spliced)
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    private LocalDate convertDate(final int[] split) {
        final int year = split[0];
        final int month = split[1];
        final int day = split[2];

        final LocalDate birthDay;
        try {
            birthDay = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException();
        }

        return birthDay;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BirthDay birthDay = (BirthDay) o;
        return Objects.equals(value, birthDay.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
