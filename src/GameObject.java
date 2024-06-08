class GameObject {
    static GameObject create(/* */) {
        return new GameObject();
    }

    public void debug() {
        System.out.println("test");
    }
}

/*
public class Main {
    public static void main(String[] args) {
        GameObject x = new AAA(10);
        System.err.println(x.a);
        x.print();
    }
}

abstract class GameObject {
    int a;
    GameObject(int a0) {
        a = a0;
    }
    abstract void print();
}

class AAA extends GameObject {
    AAA(int a0) {
        super(a0);
    }

    void print() {
        System.out.println("test");
    }
}
 */