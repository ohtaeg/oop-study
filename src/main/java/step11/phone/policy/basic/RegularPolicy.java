package step11.phone.policy.basic;

import step11.phone.Call;
import step2_oop.ohtaeg.domain.Money;

import java.time.Duration;

public class RegularPolicy extends BasicRatePolicy {
    private final Money amount;
    private final Duration seconds;

    public RegularPolicy(final Money amount, final Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(final Call call) {
        System.out.println("RegularPolicy");
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
