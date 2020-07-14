# 2장 요약
- 대부분 사람들은 어떤 클래스가 필요한지 고민하고 결정한 다음 어떤 `속성`과 `메서드`가 필요한지 고민한다.
- 이런 설계는 객체지향의 본질과 멀다. 클래스가 아닌 객체에 초점을 맞춰야 한다.
- 클래스보다 어떤 객체가 필요한지 고민하자.
    - 클래스는 상태와 행동을 공유하는 객체들을 추상화 한것으로써, 클래스의 윤곽을 잡기 위해선 객체가 어떤 상태와 행동을 가지는지 결정한다.
- 객체는 독립적인 존재가 아닌 협력하는 공동체이다.
    - 다른 객체에게 도움을 주거나 의존하면서 살아가야한다.
    - 객체들의 모양과 윤곽이 잡히면 공통된 특성과 상태를 가진 객체들을 `타입`으로 분류하고 `타입`기반으로 클래스를 만든다.
    
- 개인적으로 타입으로 분류한다는 말을 적극 동의하며 이 말은 `캡슐화`와 연관있다고 생각한다.
- 일반적으로 `캡슐화`라고 하면 연관된 속성과 행위를 묶고 외부로부터 데이터 접근을 제한한다라고 알고 있다.
- 여기서 중요하게 생각하는 부분은 데이터 접근 제한보단 연관된 속성과 행위를 묶는것이라고 생각한다.
- 속성과 행위를 묶는것은 응집도를 높이는 뜻이면서 `타입`을 부여하여 **다룰 수 있도록 만들기 위해** 묶는다고 생각한다.

- 클래스 구현시 중요한것은 클래스의 경계를 구분하는것.
- 클래스는 내부 외부로 구분되며 훌륭한 설계는 공개할것만 공개하고 감출것은 감춰 경계의 명확성이 확실해 자율성을 보장하도록 한다.

### 자율적인 객체
- 객체 내부에 대한 접근을 통제하는 이유는 무엇일까? -> 객체를 자율적인 존재로 만들기 위함
- 객체지향의 핵심은 스스로 상태를 관리하고 판단하여 행동하는 자율적인 객체들의 공동체 구성하는 것.
- 그렇기 위해선 외부의 간섭을 최소화 해야한다.

- 퍼블릭 인터패이스 : 외부에서 접근 가능하도록 매개체
- 구현 : 외부에서 접근 불가능하고 오직 내부에서만 접근 가능

### 프로그래머의 자유
- 프로그래머는 클래스 작성자와 클라이언트 프로그래머를 염두하여 작성해야한다.
- 예로 클래스 작성자는 내가 만든 객체를 다른사람이 사용한다는것을 가정하고 설계해야 되기 때문에
필요한 부분만 공개하고 내부 구현을 마음대로 변경해도 외부에 영향을 끼치면 안된다.
- 이를 `구현 은닉`이라 한다.

### 협력하는 객체들의 공동체
- 기본 타입은 특정 도메인의 처럼 저장된 값이 도메인과 관련있다는 의미를 전달할 수 없다.
    - 또한 특정 도메인과 관련된 로직이 서로 다른 곳에 중복되어 구현되는 것을 막을 수 없다.
- Value Object를 활용하여 도메인의 의미를 표현하고 응집도를 높일 수 있다.

### 협력에 관한 짧은 이야기
- 객체가 다른 객체와 상호작용할 수 있는 유일한 방법은 `메시지`를 전송하는 것.
- 객체가 수신된 메시지를 처리하기 위해서 자신만의 방법을 `메서드`라고 부른다.

### 템플릿 메서드 패턴
- 부모에 알고리즘을 구현하고 중간에 필요한 처리를 자식에게 위임.
- 변하지 않는 기능은 슈퍼클래스에 만들어두고 자주 변경되며 확장할 기능은 서브클래스에서 만들도록 한다.
- 대표적으로 사용하고 있는 API들은 
- All non-abstract methods of java.io.InputStream, java.io.OutputStream, java.io.Reader and java.io.Writer.
- All non-abstract methods of java.util.AbstractList, java.util.AbstractSet and java.util.AbstractMap.
- https://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns-in-javas-core-libraries/2707195#2707195
        
### 오버라이딩 오버로딩
```java
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
/* 출력 결과를 보면 원하는 값은 DirectionStrategy과 BodyDirectionStrategy이 출력되길 기대하지만 실제론 그렇게 출력이 되지 않습니다.
왜냐하면 오버로딩은 컴파일 시점에 메서드가 결정되는 정적 디스패처이기 때문입니다. 
컴파일시 다형성을 보장할 수 없기 때문에 개인적으로는 메소드 오버로딩을 지양하고 있습니다. */
```   
## 스터디
- 클래스를 먼저 정하지말고 객체를 고려하라, 유연하고 확장 가능한 설계를 하라
- 