package step10.effective_java_item17;

public class Child extends Parent {

    public boolean add() {
        return false;
    }

    @Override
    public boolean addAll() {
        return super.addAll();
    }
}
