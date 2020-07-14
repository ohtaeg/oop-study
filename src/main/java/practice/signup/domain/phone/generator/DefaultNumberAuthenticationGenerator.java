package practice.signup.domain.phone.generator;

public class DefaultNumberAuthenticationGenerator implements PhoneAuthenticationNumberGenerator {
    @Override
    public String generate() {
        return String.valueOf(1234);
    }
}
