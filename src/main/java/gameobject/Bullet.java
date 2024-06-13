package gameobject;
import java.awt.*;

import gameobject.character.Character;

public class Bullet extends GameObject {
    private Class<? extends Character> ownedBy;
    private Class<? extends Character> damageTo;
    private double offence;
    
    public Bullet(int x, int y, int size, int velocityX, int velocityY, Color color, Class<? extends Character> ownedBy, Class<? extends Character> damageTo, double offence) {
        super(x, y, size, velocityX, velocityY, color);
        setOwnedBy(ownedBy);
        setDamageTo(damageTo);
        setOffence(offence);
    }

    Class<? extends Character> whomOwnedBy() {
        return ownedBy;
    }

    Class<? extends Character> whomDamageTo() {
        return damageTo;
    }

    double getOffece() {
        return offence;
    }

    void setOwnedBy(Class<? extends Character> ownedBy) {
        this.ownedBy = ownedBy;
    }

    void setDamageTo(Class<? extends Character> damageTo) {
        this.damageTo = damageTo;
    }

    void setOffence(double offence) {
        this.offence = offence;
    }

    //仮だよ
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }

    public void task() {
            setTimer(0);
            move(getCoordinateX() + getVelocityX(), getCoordinateY() + getVelocityY());
    }
}