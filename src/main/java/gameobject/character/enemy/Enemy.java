package gameobject.character.enemy;

import gameobject.Bullet;
import gameobject.GameObject;
import gameobject.character.Character;

import java.awt.*;

import GameRegistrer.GameRegistrer;

abstract public class Enemy extends Character {
    private int health;
    //private Double velocityX;
    //private double velocityY;

    public Enemy(int x, int y, int size, Color color, String name, double bulletOffence, double bulletVelocityX, double bulletVelocityY, int shootInterval, int health) {
        super(x, y, size, color, name, bulletOffence, bulletVelocityX, bulletVelocityY, shootInterval);
        setHealth(health);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void collided(GameObject collidedWith) {
        if (collidedWith instanceof Bullet) {
            Bullet collidedBullet = (Bullet)collidedWith;
            if (collidedBullet.whomDamageTo() == Enemy.class) {
                setHealth(getHealth() - (int)collidedBullet.getOffence());

                // 弾の消去
                GameRegistrer.removeFromRegistry(collidedBullet);
            }
        }
    }
    
}