package gameobject;
import java.awt.*;

import gameobject.character.Character;

public class Bullet extends GameObject {
    private Class<? extends Character> ownedBy;
    private Class<? extends Character> damageTo;
    private Double offence;
    private Double velocity;
    
    public Bullet(int x, int y, int size, Class<? extends Character> ownedBy, Class<? extends Character> damageTo, double offence, double velocity) {
        super(x, y, size);
        setOwnedBy(ownedBy);
        setDamageTo(damageTo);
        setOffence(offence);
        setVelocity(velocity);
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

    double getVelocity() {
        return velocity;
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

    void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    //仮だよ
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }
}