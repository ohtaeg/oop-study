package step10.phone.after;

import step10.Call;
import step2_oop.ohtaeg.domain.Money;

import java.time.Duration;

public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    private final Money nightlyAmount;
    private final Money regularAmount;
    private final Duration seconds;

    public NightlyDiscountPhone(final double taxRate, final Money nightlyAmount, final Money regularAmount, final Duration seconds) {
        super(taxRate);
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(final Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }
        return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
