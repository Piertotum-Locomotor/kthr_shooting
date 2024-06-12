package main;

abstract class GameObject {
    private Boolean isMovable = true;
    private int coordinateX;
    private int coordinateY;
    private Boolean isAlive;
    private int size;

    Boolean getIsMovable() {
        return isMovable;
    }

    int getCoordinateX() {
        return coordinateX;
    }

    int getCoordinateY() {
        return coordinateY;
    }

    Boolean getIsAlive() {
        return isAlive;
    }

    int getSize() {
        return size;
    }

    void setIsMovable(Boolean isMovable) {
        this.isMovable = isMovable;
    }
    
    void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    void setCoordinateY(int coordinateY) {
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
}