package step10.effective_java_item17;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));

        System.out.println(s.getAddCount());

        Child child = new Child();
        child.addAll();
    }
}
