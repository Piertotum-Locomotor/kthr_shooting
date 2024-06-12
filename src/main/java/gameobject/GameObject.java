package gameobject;
import java.awt.*;

public abstract class GameObject {
    private Boolean isMovable = true;
    private int coordinateX;
    private int coordinateY;
    private Boolean isAlive;
    private int size;

    public GameObject(int x, int y, int size) {
        setCoordinateX(x);
        setCoordinateY(y);
        setSize(size);
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

    void setIsMovable(Boolean isMovable) {
        this.isMovable = isMovable;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    void setSize(int size) {
        this.size = size;
    }

    void toggleIsAlive() {
        isAlive = !(isAlive);
    }

    abstract public void draw(Graphics g);
}