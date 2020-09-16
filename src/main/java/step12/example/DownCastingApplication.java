package step12.example;

import java.util.Arrays;
import java.util.List;

public class DownCastingApplication {
    public static void main(String[] args) {
        List<SmartPhone> phoneList = Arrays.asList(new IPhone(), new Galaxy());
        Game game = new Game();
        //phoneList.forEach(game::play); // 컴파일 에러 발생
    }
}
