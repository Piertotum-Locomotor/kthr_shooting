package gameobject;
import java.awt.*;

public abstract class GameObject {
    private Boolean isMovable = true;
    private int coordinateX;
    private int coordinateY;
    private Boolean isAlive;
    private int size;
    private int velocityX;
    private int velocityY;

    public GameObject(int x, int y, int size, int velocityX, int velocityY) {
        setCoordinateX(x);
        setCoordinateY(y);
        setSize(size);
        setVelocityX(velocityX);
        setVelocityY(velocityY);
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

    public int getVelocityX() {
        return velocityX;
    }

    public int getVelocityY() {
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

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public void toggleIsAlive() {
        isAlive = !(isAlive);
    }

    public void move(int newX, int newY) {
        setCoordinateX(newX);
        setCoordinateY(newY);
    }

    abstract public void draw(Graphics g);
}