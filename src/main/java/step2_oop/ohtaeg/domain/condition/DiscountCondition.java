package step2_oop.ohtaeg.domain.condition;

import step2_oop.ohtaeg.domain.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
