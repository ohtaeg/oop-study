package step2_oop.ohtaeg.domain.policy;

import step2_oop.ohtaeg.domain.Money;
import step2_oop.ohtaeg.domain.Screening;
import step2_oop.ohtaeg.domain.condition.DiscountCondition;

public class PercentDiscountPolicy extends DiscountPolicy {
    private final double percent;

    public PercentDiscountPolicy(final double percent, final DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(final Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
