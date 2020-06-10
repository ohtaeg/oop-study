package step2_oop.ohtaeg.domain.policy;

import step2_oop.ohtaeg.domain.Money;
import step2_oop.ohtaeg.domain.Screening;
import step2_oop.ohtaeg.domain.condition.DiscountCondition;

public class AmountDiscountPolicy extends DiscountPolicy {
    private final Money discountAmount;

    public AmountDiscountPolicy(final Money discountAmount, final DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(final Screening screening) {
        return discountAmount;
    }
}
