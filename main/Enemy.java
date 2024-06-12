package main;

public class Enemy extends Character {
    int health;
    Double velocity;
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
}

