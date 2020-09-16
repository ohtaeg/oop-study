package step12.example;

public class Game {
    public void play(IPhone phone) {
        System.out.println("iphone play [" + phone.getClass().getSimpleName() + "]");
    }

    public void play(Galaxy phone) {
        System.out.println("gallaxy play [" + phone.getClass().getSimpleName() + "]");
    }
}

interface SmartPhone{
}

class IPhone implements SmartPhone{

}

class Galaxy implements SmartPhone{

}
