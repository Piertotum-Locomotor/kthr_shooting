package gameobject.character.player;

import gameobject.character.Character;
import gameobject.character.enemy.Enemy;
import gameobject.*;

import java.awt.*;

import GameRegistrer.GameRegistrer;

public class Player extends Character {
    private int remaining;

    public Player(int x, int y, int size, String name, int bulletOffence, int bulletVelocityX, int bulletVelocityY) {
        super(x, y, size, name, bulletOffence, bulletVelocityX, bulletVelocityY);
        setRemaining(remaining);
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public void shoot(double offense, double velocity) {
        Bullet bullet = new Bullet(super.getCoordinateX(), super.getCoordinateY(), super.getSize(), super.getBulletVelocityX(), super.getBulletVelocityY(), Player.class, Enemy.class, super.getBulletOffence());
        GameRegistrer.gameRegisterer(bullet);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }
}