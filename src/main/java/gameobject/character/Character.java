package gameobject.character;

import gameobject.GameObject;

public abstract class Character extends GameObject {
    private String name;
    private double bulletOffence;
    private double bulletVelocity;

    //仮
    public Character(int x, int y, int size) {
        super(x, y, size);
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

    public void move(int newX, int newY) {
        setCoordinateX(newX);
        setCoordinateY(newY);
    }
}