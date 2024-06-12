package main;

import java.awt.*;

public class Player extends Character {
    int remaining;

    //仮
    public Player(int x, int y, int size) {
        super(x, y, size);
    }

    String getName(){
        return super.name;
    }
    double getBulletOffence(){
        return super.bulletOffence;
    }
    double getBulletVelocity(){
        return super.bulletVelocity;
    }
    void setName(String name){
        super.name = name;
    }
    void setBulletOffence(Double bulletOffence){
        super.bulletOffence = bulletOffence;
    }
    void setBulletVelocity(Double bulletVelocity){
        super.bulletVelocity = bulletVelocity;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }
}