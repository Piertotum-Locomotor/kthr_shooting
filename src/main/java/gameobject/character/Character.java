package gameobject.character;

import gameobject.GameObject;

public abstract class Character extends GameObject {
    private String name;
    private double bulletOffence;
    private double bulletVelocity;

    public Character(int x, int y, int size, String name, double bulletOffence, double bulletVelocity) {
        super(x, y, size);
        setName(name);
        setBulletOffence(bulletOffence);
        setBulletVelocity(bulletVelocity);
    }

    public String getName(){
        return name;
    }

    public double getBulletOffence(){
        return bulletOffence;
    }

    public double getBulletVelocity(){
        return bulletVelocity;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public void setBulletOffence(Double bulletOffence){
        this.bulletOffence = bulletOffence;
    }

    public void setBulletVelocity(Double bulletVelocity){
        this.bulletVelocity = bulletVelocity;
    }

    protected abstract void shoot(Character damageTo, double offense, double velocity);
}