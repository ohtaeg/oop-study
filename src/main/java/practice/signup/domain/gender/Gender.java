package practice.signup.domain.gender;

import java.util.Objects;

public class Gender {
    private final GenderType gender;

    public Gender(final String gender) {
        this(GenderType.of(gender));
    }

    public Gender(final GenderType gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Gender gender1 = (Gender) o;
        return gender == gender1.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender);
    }

    @Override
    public String toString() {
        return gender.toString();
    }
}
