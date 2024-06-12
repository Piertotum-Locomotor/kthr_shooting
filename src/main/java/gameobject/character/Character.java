package gameobject.character;

import gameobject.GameObject;

public abstract class Character extends GameObject {
    private String name;
    private double bulletOffence;
    private int bulletVelocityX;
    private int bulletVelocityY;

    public Character(int x, int y, int size, String name, double bulletOffence, int bulletVelocityX, int bulletVelocityY) {
        super(x, y, size, 0, 0);
        setName(name);
        setBulletOffence(bulletOffence);
        setBulletVelocityX(bulletVelocityX);
        setBulletVelocityY(bulletVelocityY);
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

    public abstract void shoot(double offense, double velocity);
}