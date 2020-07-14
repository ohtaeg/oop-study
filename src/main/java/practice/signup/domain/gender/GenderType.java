package practice.signup.domain.gender;

import java.util.Arrays;

public enum GenderType {
    MALE("male")
    ,FEMALE("female");

    private final String type;

    GenderType(final String type) {
        this.type = type;
    }

    public static GenderType of(String value) {
        return Arrays.stream(GenderType.values())
                     .filter(gender -> gender.type == value)
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("올바른 성별이 아닙니다."));
    }
}
