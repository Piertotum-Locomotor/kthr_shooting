package gameobject.character;

import gameobject.GameObject;

import java.awt.*;

public abstract class Character extends GameObject {
    private String name;
    private double bulletOffence;
    private int bulletVelocityX;
    private int bulletVelocityY;
    private Boolean isShooting;
    private int shootInterval;

    public Character(int x, int y, int size, Color color, String name, double bulletOffence, int bulletVelocityX, int bulletVelocityY, int shootInterval) {
        super(x, y, size, 0, 0, color);
        setName(name);
        setBulletOffence(bulletOffence);
        setBulletVelocityX(bulletVelocityX);
        setBulletVelocityY(bulletVelocityY);
        setIsShooting(false);
        setShootInterval(shootInterval);
    }

    public String getName(){
        return name;
    }

    public double getBulletOffence(){
        return bulletOffence;
    }

    public int getBulletVelocityX(){
        return bulletVelocityX;
    }

    public int getBulletVelocityY(){
        return bulletVelocityY;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public void setBulletOffence(Double bulletOffence){
        this.bulletOffence = bulletOffence;
    }

    public void setBulletVelocityX(int bulletVelocityX){
        this.bulletVelocityX = bulletVelocityX;
    }

    public void setBulletVelocityY(int bulletVelocityY){
        this.bulletVelocityY = bulletVelocityY;
    }

    public Boolean getIsShooting() {
        return isShooting;
    }

    public void setIsShooting(Boolean isShooting) {
        this.isShooting = isShooting;
    }

    public void toggleShoot() {
        isShooting = !isShooting;
    }

    public int getShootInterval() {
        return shootInterval;
    }

    public void setShootInterval(int shootInterval) {
        this.shootInterval = shootInterval;
    }

    public abstract void shoot();
}