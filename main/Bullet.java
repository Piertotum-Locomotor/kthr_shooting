package main;

abstract class Bullet extends GameObject {
    Character ownedBy;
    Character damageTo;
    Double offense;
    Double velocity;

    abstract Character whomOwnedBy();
    abstract Character whomDamageTo();
    abstract double getOffece();
    abstract double getVelocity();

    abstract Character setOwnedBy();
    abstract Character setDamageTo();
    abstract void setName();
    abstract void setOffece();
    abstract void setVelocity();
}