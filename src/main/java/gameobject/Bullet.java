package gameobject;
import java.awt.*;

import gameobject.character.Character;

class Bullet extends GameObject {
    private Character ownedBy;
    private Character damageTo;
    private Double offence;
    private Double velocity;
    
    public Bullet(int x, int y, int size, Character ownedBy, Character damageTo, double offence, double velocity) {
        super(x, y, size);
        setOwnedBy(ownedBy);
        setDamageTo(damageTo);
        setOffence(offence);
        setVelocity(velocity);
    }

    Character whomOwnedBy() {
        return ownedBy;
    }

    Character whomDamageTo() {
        return damageTo;
    }

    double getOffece() {
        return offence;
    }

    double getVelocity() {
        return velocity;
    }

    void setOwnedBy(Character ownedBy) {
        this.ownedBy = ownedBy;
    }

    void setDamageTo(Character damageTo) {
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