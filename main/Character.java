package main;

abstract class Character extends GameObject {
    String name;
    double bulletOffence;
    double bulletVelocity;

    abstract String getName();
    abstract double getBulletOffece();
    abstract double getBulletVelocity();

    abstract void setName();
    abstract void setBulletOffece();
    abstract void setBulletVelocity();
}