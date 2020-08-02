package step11.example.mixin;

public class MixinExecutor {
    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.makeView();       // Frontend
        developer.makeLogic();      // Server
        developer.connectDB();      // Server
        developer.useAws();         // Infra
        developer.process();        // DevOps
    }
}
