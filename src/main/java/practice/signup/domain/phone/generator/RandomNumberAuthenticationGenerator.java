package practice.signup.domain.phone.generator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberAuthenticationGenerator implements PhoneAuthenticationNumberGenerator {
    private final Random random = ThreadLocalRandom.current();

    @Override
    public String generate() {
        return String.valueOf(random.nextInt(8999) + 1000);
    }
}
