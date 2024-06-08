public class Main {
    public static void main(String[] args) {
        GameObject x = GameObject.create();
        x.debug();
    }
}

// テストメッセージ

interface GameObject {
    static GameObject create(/* */) {
        return new GameObjectImpl();
    }

    void debug();
}

class GameObjectImpl implements GameObject {
    // private double ...

    GameObjectImpl(/* */) {
        // ...
    }

    public void debug() {
        System.out.println("test");
    }
}
