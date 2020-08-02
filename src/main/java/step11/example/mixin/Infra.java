package step11.example.mixin;

public interface Infra {
    default void useAws() {
        System.out.println("Infra Developer use EC2");
    }
}
