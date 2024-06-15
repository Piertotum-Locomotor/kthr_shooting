package GameRegistrer;

import java.util.ArrayList;

import gameobject.GameObject;

public class GameRegistrer {
    public static ArrayList<GameObject> objects = new ArrayList<>(); //リスト(動的配列)

    public static void gameRegisterer(GameObject Instance) {
        objects.add(Instance);
    }

    public static void removeFromRegistry(GameObject Instance) {
        objects.remove(Instance);
    }

    public static ArrayList<GameObject> getObjects() {
        return objects;
    }
}