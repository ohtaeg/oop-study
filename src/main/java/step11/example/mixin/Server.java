package step11.example.mixin;

public interface Server {
    default void makeLogic() {
        System.out.println("Server Developer create domain logic");
    }

    default void connectDB() {
        System.out.println("Server Developer connect MySql");
    }
}
