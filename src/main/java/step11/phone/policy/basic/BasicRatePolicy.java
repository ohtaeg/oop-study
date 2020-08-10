package step11.phone.policy.basic;

import step11.phone.Call;
import step11.phone.Phone;
import step11.phone.policy.RatePolicy;
import step2_oop.ohtaeg.domain.Money;

public abstract class BasicRatePolicy implements RatePolicy {
    @Override
    public Money calculateFee(final Phone phone) {
        Money result = Money.ZERO;
        for (Call call : phone.getCalls()) {
            result.plus(calculateCallFee(call));
        }
        return result;
    }

    protected abstract Money calculateCallFee(Call call);
}
