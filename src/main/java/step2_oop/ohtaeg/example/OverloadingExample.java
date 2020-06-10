package step2_oop.ohtaeg.example;

import step2_oop.ohtaeg.domain.Money;
import step2_oop.ohtaeg.domain.Screening;
import step2_oop.ohtaeg.domain.policy.AmountDiscountPolicy;
import step2_oop.ohtaeg.domain.policy.DiscountPolicy;
import step2_oop.ohtaeg.domain.policy.PercentDiscountPolicy;

import java.util.Arrays;
import java.util.List;

public class OverloadingExample {
    public static void getPolicy(DiscountPolicy discountPolicy) {
        System.out.println("DiscountPolicy");
    }

    public static void getPolicy(AmountDiscountPolicy amountDiscountPolicy) {
        System.out.println("AmountDiscountPolicy");
    }

    public static void getPolicy(PercentDiscountPolicy percentDiscountPolicy) {
        System.out.println("PercentDiscountPolicy");
    }

    public static void getPolicy(Object DiscountPolicy) {
        System.out.println("Object");
    }

    public static void main(String[] args) {
        List<?> list = Arrays.asList(new DiscountPolicy() {
            @Override
            protected Money getDiscountAmount(final Screening screening) {
                return null;
            }
        }, new AmountDiscountPolicy(Money.ZERO), new PercentDiscountPolicy(0));

        list.stream()
            .forEach(policy -> getPolicy(policy));
    }
}
