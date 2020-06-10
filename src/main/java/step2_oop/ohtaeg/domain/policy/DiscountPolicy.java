package step2_oop.ohtaeg.domain.policy;

import step2_oop.ohtaeg.domain.Money;
import step2_oop.ohtaeg.domain.Screening;
import step2_oop.ohtaeg.domain.condition.DiscountCondition;

import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private final List<DiscountCondition> conditions;

    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    protected abstract Money getDiscountAmount(final Screening screening);
}
