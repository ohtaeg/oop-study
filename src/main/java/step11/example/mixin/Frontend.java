package step11.example.mixin;

public interface Frontend {
    default void makeView() {
        System.out.println("Frontend Developer use React.js");
    }
}
