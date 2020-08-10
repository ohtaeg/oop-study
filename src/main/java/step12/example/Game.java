package step12.example;

public class Game {
    public void play(Iphone phone) {
        System.out.println("iphone play [" + phone.getClass().getSimpleName() + "]");
    }

    public void play(Gallaxy phone) {
        System.out.println("gallaxy play [" + phone.getClass().getSimpleName() + "]");
    }
}

interface SmartPhone{
}

class Iphone implements SmartPhone{

}

class Gallaxy implements SmartPhone{

}
