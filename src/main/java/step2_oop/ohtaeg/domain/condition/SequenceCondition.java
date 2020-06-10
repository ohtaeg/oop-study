package step2_oop.ohtaeg.domain.condition;

import step2_oop.ohtaeg.domain.Screening;

public class SequenceCondition implements DiscountCondition {
    private final int sequence;

    public SequenceCondition(final int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(final Screening screening) {
        return screening.isSequence(sequence);
    }
}
