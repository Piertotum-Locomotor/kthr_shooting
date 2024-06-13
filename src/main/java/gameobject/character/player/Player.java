package gameobject.character.player;

import gameobject.character.Character;
import gameobject.character.enemy.Enemy;
import gameobject.*;

import java.awt.*;

import GameRegistrer.GameRegistrer;

public class Player extends Character {
    private int remaining;

    public Player(int x, int y, int size, Color color, String name, int bulletOffence, int bulletVelocityX, int bulletVelocityY, int shootInterval) {
        super(x, y, size, color, name, bulletOffence, bulletVelocityX, bulletVelocityY, shootInterval);
        setRemaining(remaining);
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public void shoot() {
        Bullet bullet = new Bullet(super.getCoordinateX(), super.getCoordinateY(), super.getSize(), super.getBulletVelocityX(), super.getBulletVelocityY(), super.getColor(), Player.class, Enemy.class, super.getBulletOffence());
        GameRegistrer.gameRegisterer(bullet);
    }

    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }

    public void task() {
        if (getTimer() % getShootInterval() == 0 && getIsShooting()) {
            setTimer(0);
            shoot();
        }
    }
}