package step4.ohtaeg.shape;

public class Rectangle {
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Rectangle(final int left, final int top, final int right, final int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(final int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(final int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(final int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(final int bottom) {
        this.bottom = bottom;
    }
}
