package gameobject.character.enemy;

import GameRegistrer.GameRegistrer;
import gameobject.Bullet;
import gameobject.character.player.Player;
import gameobject.ui.HPBar;
import java.awt.*;

public class Zako extends Enemy {
    private HPBar hpBar;

    public Zako(int x, int y, int size, Color color, String name, double bulletOffence, double bulletVelocityX, double bulletVelocityY, int shootInterval, int health) {
         super(x, y, size, color, name, bulletOffence, bulletVelocityX, bulletVelocityY, shootInterval, health);
        hpBar = new HPBar(x - 20, y - size/2 - 10, 40, Color.GREEN, health);
        GameRegistrer.gameRegisterer(hpBar);
        }

    public void shoot() {
        Bullet bullet = new Bullet(super.getCoordinateX(), super.getCoordinateY(), super.getSize(), super.getBulletVelocityX(), super.getBulletVelocityY(), super.getColor(), Zako.class, Player.class, super.getBulletOffence());
        GameRegistrer.gameRegisterer(bullet);
    }

    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
        hpBar.draw(g);
    }
    
    public void task() {
        setIsShooting(true);

        if (getTimer() % getShootInterval() == 0) {

            if (getIsShooting()) {
                shoot();
            }
        }

        if (getTimer() >= 60 * 3) {
            super.moveLiner(100, 100);
        }

        if (getHealth() <= 0) {
            GameRegistrer.removeFromRegistry(this);
            GameRegistrer.removeFromRegistry(hpBar);
        }

        hpBar.setValue(getHealth());
        hpBar.setCoordinateX(getCoordinateX() - hpBar.getSize() / 2);
        hpBar.setCoordinateY(getCoordinateY() - getSize() / 2 - 10);
    }
}