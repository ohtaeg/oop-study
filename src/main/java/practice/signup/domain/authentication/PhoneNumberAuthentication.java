package practice.signup.domain.authentication;

import practice.signup.domain.phone.generator.PhoneAuthenticationNumberGenerator;

public class PhoneNumberAuthentication implements Authentication {
    private final PhoneAuthenticationNumberGenerator numberGenerator;

    public PhoneNumberAuthentication(final PhoneAuthenticationNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isSatisfied(final String certificationNumber) {
        return certificationNumber.equals(numberGenerator.generate());
    }
}
