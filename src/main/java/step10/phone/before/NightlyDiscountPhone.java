package step10.phone.before;

import step10.Call;
import step2_oop.ohtaeg.domain.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private final double taxRate;
    private final Money nightlyAmount;
    private final Money regularAmount;
    private final Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public NightlyDiscountPhone(final double taxRate, final Money nightlyAmount, final Money regularAmount, final Duration seconds) {
        this.taxRate = taxRate;
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;
        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }
        }
        return result.minus(result.times(taxRate));
    }
}
