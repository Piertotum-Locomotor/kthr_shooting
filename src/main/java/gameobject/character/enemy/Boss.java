package gameobject.character.enemy;

import GameRegistrer.GameRegistrer;
import gameobject.Bullet;
import gameobject.character.player.Player;
import gameobject.ui.*;
import java.awt.*;

public class Boss extends Enemy {
    private double currentAngle;

    HPBar hpbar;
    public Boss(int x, int y, int size, Color color, String name, double bulletOffence, double bulletVelocityX, double bulletVelocityY, int shootInterval, int health) {
        super(x, y, size, color, name, bulletOffence, bulletVelocityX, bulletVelocityY, shootInterval, health);
        this.currentAngle = 0; // 初期角度を0に設定
        
        hpbar = new HPBar(0, 10, 100, Color.GREEN, getHealth());
        GameRegistrer.gameRegisterer(hpbar);   
    }

    public void shoot() {
        int bulletCount = 6; // 同心円状に発射する弾の数
        double angleStep = 360.0 / bulletCount;
        double bulletSpeed = 6.0; // 弾の基本速度

        for (int i = 0; i < bulletCount; i++) {
            double angle = Math.toRadians(currentAngle + i * angleStep);
            double bulletVelocityX = bulletSpeed * Math.cos(angle);
            double bulletVelocityY = bulletSpeed * Math.sin(angle);
            
            Bullet bullet = new Bullet(super.getCoordinateX(), super.getCoordinateY(), super.getSize() / 2, bulletVelocityX, bulletVelocityY, super.getColor(), Boss.class, Player.class, super.getBulletOffence());
            GameRegistrer.gameRegisterer(bullet);
        }

        // 打ち出す角度を変えていくやつ
        // だが、変数の型(int)が悪さをしているため、思うような軌道にはならない
        currentAngle += 1;
        if (currentAngle % 360 == 0) {
            currentAngle = 0;
        }
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

        hpbar.setValue(getHealth());
    }
}