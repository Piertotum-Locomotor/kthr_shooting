public class ShootingGame {
    public static void main(String[] args) {
        GameObject x = new Test(10);
        GameObject y = new Character(100);
        System.out.println(x.a);
    }
}

abstract class GameObject {
    int a;
    GameObject(int a0) {
        a = a0;
    }
}

class Character extends GameObject {
    Character(int a0) {
        super(a0);
    }
}

























class Test extends GameObject {
    Test(int a0) {
        super(a0);
    }

    void print() {
        System.out.println("test");
    }
}
