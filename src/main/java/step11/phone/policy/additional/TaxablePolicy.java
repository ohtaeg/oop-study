package step11.phone.policy.additional;

import step11.phone.policy.RatePolicy;
import step2_oop.ohtaeg.domain.Money;

public class TaxablePolicy extends AdditionalRatePolicy {
    private final double taxRatio;

    public TaxablePolicy(final RatePolicy next, final double taxRatio) {
        super(next);
        this.taxRatio = taxRatio;
    }

    @Override
    protected Money afterCalculateFee(final Money fee) {
        return fee.plus(fee.times(taxRatio));
    }
}
