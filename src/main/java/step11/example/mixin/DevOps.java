package step11.example.mixin;

public interface DevOps {
    default void process() {
        System.out.println("Devops work build, test, monitoring, etc..");
    }
}
