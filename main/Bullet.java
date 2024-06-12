package main;

class Bullet extends GameObject {
    private Character ownedBy;
    private Character damageTo;
    private Double offense;
    private Double velocity;

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
}