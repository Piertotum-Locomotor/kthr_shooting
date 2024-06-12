package main;

import java.awt.*;

class Bullet extends GameObject {
    private Character ownedBy;
    private Character damageTo;
    private Double offense;
    private Double velocity;
    
    //仮
    public Bullet(int x, int y, int size) {
        super(x, y, size);
    }

    Character whomOwnedBy() {
        return ownedBy;
    }

    Character whomDamageTo() {
        return damageTo;
    }

    double getOffece() {
        return offense;
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

    void setOffece(double offense) {
        this.offense = offense;
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