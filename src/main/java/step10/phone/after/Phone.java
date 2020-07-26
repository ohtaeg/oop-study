package step10.phone.after;

import step10.Call;
import step2_oop.ohtaeg.domain.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    private double taxRate;
    private List<Call> calls = new ArrayList<>();

    public Phone(final double taxRate) {
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;
        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }
        return result.plus(result.times(taxRate));
    }

    protected abstract Money calculateCallFee(final Call call);
}
