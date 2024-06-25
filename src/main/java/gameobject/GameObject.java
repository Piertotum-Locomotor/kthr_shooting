package gameobject;
import java.awt.*;

public abstract class GameObject {
    private Boolean isMovable = true;
    private int coordinateX;
    private int coordinateY;
    private Boolean isAlive;
    private int size;
    private double velocityX;
    private double velocityY;
    private int timer;
    private Color color;

    public GameObject(int x, int y, int size, double velocityX, double velocityY, Color color) {
        setCoordinateX(x);
        setCoordinateY(y);
        setSize(size);
        setVelocityX(velocityX);
        setVelocityY(velocityY);
        setColor(color);
        setTimer(0);
    }

    Boolean getIsMovable() {
        return isMovable;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public Boolean getIsAlive() {
        return isAlive;
    }

    public int getSize() {
        return size;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setIsMovable(Boolean isMovable) {
        this.isMovable = isMovable;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    public void setSize(int size) {
        this.size = size;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public void toggleIsAlive() {
        isAlive = !(isAlive);
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void incrementTimer() {
        timer++;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void move(int newX, int newY) {
        setCoordinateX(newX);
        setCoordinateY(newY);
    }

    abstract public void draw(Graphics g);

    abstract public void task();
}