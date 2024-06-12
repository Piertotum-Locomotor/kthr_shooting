package gameobject.character.player;

import gameobject.character.Character;

import java.awt.*;

public class Player extends Character {
    int remaining;

    //仮
    public Player(int x, int y, int size) {
        super(x, y, size);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }
}