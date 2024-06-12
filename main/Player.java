package main;

public class Player extends Character{
    int remaining;
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
    void setBulletOffence(Double nulletOffence){
        super.bulletOffence = nulletOffence;
    }
    void setBulletVelocity(Double bulletVelocity){
        super.bulletVelocity = bulletVelocity;
    }
}