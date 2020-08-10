package step11.phone.policy.additional;

import step11.phone.policy.RatePolicy;
import step2_oop.ohtaeg.domain.Money;

public class RateDiscountPolicy extends AdditionalRatePolicy {
    private final Money discountAmount;

    public RateDiscountPolicy(final RatePolicy next, final Money discountAmount) {
        super(next);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculateFee(final Money fee) {
        return fee.minus(discountAmount);
    }
}
