package practice.signup.domain.dto;

public class SignUpRequest {
    private final String id;
    private final String password;
    private final String reConfirmPassword;
    private final String name;
    private final String birthDay;
    private final String gender;
    private final String email;
    private final String phoneNumber;
    private final String certificationPhoneNumber;

    private SignUpRequest(Builder builder) {
        this.id = builder.id;
        this.password = builder.password;
        this.reConfirmPassword = builder.reConfirmPassword;
        this.name = builder.name;
        this.birthDay = builder.birthDay;
        this.gender = builder.gender;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.certificationPhoneNumber = builder.certificationPhoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getReConfirmPassword() {
        return reConfirmPassword;
    }

    public String getName() {
        return name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCertificationPhoneNumber() {
        return certificationPhoneNumber;
    }

    @Override
    public String toString() {
        return "SignUpRequest{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", reConfirmPassword='" + reConfirmPassword + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", certificationPhoneNumber='" + certificationPhoneNumber + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String password;
        private String reConfirmPassword;
        private String name;
        private String birthDay;
        private String gender;
        private String email;
        private String phoneNumber;
        private String certificationPhoneNumber;

        public Builder(final String id, final String password) {
            this.id = id;
            this.password = password;
        }

        public Builder reConfirmPassword(String reConfirmPassword) {
            this.reConfirmPassword = reConfirmPassword;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder birthDay(String birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder certificationPhoneNumber(String certificationPhoneNumber) {
            this.certificationPhoneNumber = certificationPhoneNumber;
            return this;
        }

        public SignUpRequest build() {
            return new SignUpRequest(this);
        }
    }
}
