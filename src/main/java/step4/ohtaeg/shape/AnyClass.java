package step4.ohtaeg.shape;

public class AnyClass {
    /**
     * 코드중복이 발생활 확률이 높음
     * 변경에 취약함
     * @param rectangle
     * @param multiple
     */
    void doSomething(Rectangle rectangle, int multiple) {
        rectangle.setBottom(rectangle.getBottom() * multiple);
        rectangle.setRight(rectangle.getRight() * multiple);
    }
}
