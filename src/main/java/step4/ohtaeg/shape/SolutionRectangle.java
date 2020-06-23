package step4.ohtaeg.shape;

public class SolutionRectangle {
    private int right;

    /**
     * Rectangle 스스로 증가시키도록 책임을 위임
     * @param multiple
     */
    public void enlarge(int multiple) {
        right *= multiple;
    }
}
