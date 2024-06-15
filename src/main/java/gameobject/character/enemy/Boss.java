package gameobject.character.enemy;

import gameobject.Bullet;
import gameobject.character.player.Player;

import java.awt.*;

import GameRegistrer.GameRegistrer;

public class Boss extends Enemy {

    public Boss(int x, int y, int size, Color color, String name, double bulletOffence, int bulletVelocityX, int bulletVelocityY, int shootInterval, int health) {
        super(x, y, size, color, name, bulletOffence, bulletVelocityX, bulletVelocityY, shootInterval, health);
    }

    public void shoot() {
        Bullet bullet = new Bullet(super.getCoordinateX(), super.getCoordinateY(), super.getSize()/2, super.getBulletVelocityX(), super.getBulletVelocityY(), super.getColor(), Boss.class, Player.class, super.getBulletOffence());
        GameRegistrer.gameRegisterer(bullet);
    }

    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }

    public void task() {
        setIsShooting(true);

        if (getTimer() % getShootInterval() == 0) {
            setTimer(0);

            if (getIsShooting()) {
                shoot();
            }
        }
        

        if (getHealth() <= 0) {
            GameRegistrer.removeFromRegistry(this);
        }
    }
}