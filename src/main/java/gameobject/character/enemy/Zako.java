package gameobject.character.enemy;

import gameobject.Bullet;
import gameobject.character.player.Player;

import java.awt.*;

import GameRegistrer.GameRegistrer;

public class Zako extends Enemy {

    public Zako(int x, int y, int size, String name, double bulletOffence, int bulletVelocityX, int bulletVelocityY) {
        super(x, y, size, name, bulletOffence, bulletVelocityX, bulletVelocityY);
    }

    public void shoot(double offense, double velocity) {
        Bullet bullet = new Bullet(super.getCoordinateX(), super.getCoordinateY(), super.getSize(), super.getBulletVelocityX(), super.getBulletVelocityY(), Zako.class, Player.class, super.getBulletOffence());
        GameRegistrer.gameRegisterer(bullet);
    }

    //仮だよ
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }
    
}