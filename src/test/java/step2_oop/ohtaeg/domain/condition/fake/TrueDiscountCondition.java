package step2_oop.ohtaeg.domain.condition.fake;

import step2_oop.ohtaeg.domain.Screening;
import step2_oop.ohtaeg.domain.condition.DiscountCondition;

public class TrueDiscountCondition implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(final Screening screening) {
        return true;
    }
}
