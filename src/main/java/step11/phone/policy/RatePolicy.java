package step11.phone.policy;

import step11.phone.Phone;
import step2_oop.ohtaeg.domain.Money;

/**
 * 기본 정책과 부가 정책을 포함한다.
 */
public interface RatePolicy {
    Money calculateFee(Phone phone);
}
