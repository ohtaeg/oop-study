package step11.phone.policy.basic;

import step11.phone.Call;
import step11.phone.policy.basic.BasicRatePolicy;
import step2_oop.ohtaeg.domain.Money;

import java.time.Duration;

public class NightlyDiscountPolicy extends BasicRatePolicy {
    private static final int LATE_NIGHT_HOUR = 22;

    private final Money nightAmount;
    private final Money regularAmount;
    private final Duration seconds;

    public NightlyDiscountPolicy(final Money nightAmount, final Money regularAmount, final Duration seconds) {
        this.nightAmount = nightAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(final Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }
        return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
