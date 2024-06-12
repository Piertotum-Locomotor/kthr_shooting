abstract class Character extends GameObject {
    String name;
    double bulletOffence;
    double bulletVelocity;

    //仮
    public Character(int x, int y, int size) {
        super(x, y, size);
    }

    abstract String getName();
    abstract double getBulletOffence();
    abstract double getBulletVelocity();

    abstract void setName(String name);
    abstract void setBulletOffence(Double bulletOffence);
    abstract void setBulletVelocity(Double bulletVelocity);

    public void move(int newX, int newY) {
        setCoordinateX(newX);
        setCoordinateY(newY);
    }
}