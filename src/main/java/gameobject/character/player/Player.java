package gameobject.character.player;

import gameobject.character.Character;

import java.awt.*;

public class Player extends Character {
    private int remaining;

    public Player(int x, int y, int size, String name, double bulletOffence, double bulletVelocity) {
        super(x, y, size, name, bulletOffence, bulletVelocity);
        setRemaining(remaining);
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }
}