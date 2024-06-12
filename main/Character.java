package main;

abstract class Character extends GameObject {
    String name;
    double bulletOffence;
    double bulletVelocity;

    abstract String getName();
    abstract double getBulletOffence();
    abstract double getBulletVelocity();

    abstract void setName(String name);
    abstract void setBulletOffence(Double bulletOffence);
    abstract void setBulletVelocity(Double bulletVelocity);
}