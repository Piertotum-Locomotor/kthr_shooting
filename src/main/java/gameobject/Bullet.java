package gameobject;

import java.awt.*;

import GameRegistrer.GameRegistrer;
import gameobject.character.Character;

public class Bullet extends GameObject {
    private Class<? extends Character> ownedBy;
    private Class<? extends Character> damageTo;
    private double offence;

    public Bullet(int x, int y, int size, double velocityX, double velocityY, Color color,
            Class<? extends Character> ownedBy, Class<? extends Character> damageTo, double offence) {
        super(x, y, size, velocityX, velocityY, color);
        setOwnedBy(ownedBy);
        setDamageTo(damageTo);
        setOffence(offence);
    }

    public Class<? extends Character> whomOwnedBy() {
        return ownedBy;
    }

    public Class<? extends Character> whomDamageTo() {
        return damageTo;
    }

    public double getOffence() {
        return offence;
    }

    public void setOwnedBy(Class<? extends Character> ownedBy) {
        this.ownedBy = ownedBy;
    }

    public void setDamageTo(Class<? extends Character> damageTo) {
        this.damageTo = damageTo;
    }

    public void setOffence(double offence) {
        this.offence = offence;
    }

    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2,
                super.getSize(), super.getSize());
    }

    public void task() {
        move((int)(getCoordinateX() + getVelocityX()), (int)(getCoordinateY() + getVelocityY()));

<<<<<<< HEAD
        if (getTimer() >= 60 * 60) {
            setTimer(0);
=======
            if (getTimer() >= 60 * 15) {
                setTimer(0);
>>>>>>> 87c88f0fbb5ba508accbc16aba039550c24e58e4

            GameRegistrer.removeFromRegistry(this);
        }
    }
}