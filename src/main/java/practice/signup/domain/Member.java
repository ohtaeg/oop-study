package practice.signup.domain;

import practice.signup.domain.gender.Gender;
import practice.signup.domain.phone.Phone;

public class Member {
    private final Id id;
    private final Password password;
    private final Name name;
    private final Gender gender;
    private final BirthDay birthDay;
    private final Phone phone;

    public Member(final Id id, final Password password, final Name name, final Gender gender, final BirthDay birthDay, final Phone phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.phone = phone;
    }

    public Id getId() {
        return id;
    }
}
