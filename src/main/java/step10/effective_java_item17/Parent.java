package step10.effective_java_item17;

public class Parent {
    public boolean addAll() {
        add();
        return true;
    }

    public boolean add() {
        throw new UnsupportedOperationException();
    }
}
