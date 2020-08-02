package step11.phone.policy.additional;

import step11.phone.Phone;
import step11.phone.policy.RatePolicy;
import step2_oop.ohtaeg.domain.Money;

public abstract class AdditionalRatePolicy implements RatePolicy {
    private final RatePolicy next;

    public AdditionalRatePolicy(final RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(final Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculateFee(fee);
    }

    protected abstract Money afterCalculateFee(final Money fee);
}
