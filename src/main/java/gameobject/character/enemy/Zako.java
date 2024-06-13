package gameobject.character.enemy;

import gameobject.Bullet;
import gameobject.character.player.Player;

import java.awt.*;

import GameRegistrer.GameRegistrer;

public class Zako extends Enemy {

    public Zako(int x, int y, int size, Color color, String name, double bulletOffence, int bulletVelocityX, int bulletVelocityY, int shootInterval) {
        super(x, y, size, color, name, bulletOffence, bulletVelocityX, bulletVelocityY, shootInterval);
    }

    public void shoot() {
        Bullet bullet = new Bullet(super.getCoordinateX(), super.getCoordinateY(), super.getSize(), super.getBulletVelocityX(), super.getBulletVelocityY(), super.getColor(), Zako.class, Player.class, super.getBulletOffence());
        GameRegistrer.gameRegisterer(bullet);
    }

    //仮だよ
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }
    
    public void task() {
        if (getTimer() % 10 == 0 && getIsShooting()) {
            setTimer(0);
            shoot();
        }
    }
}