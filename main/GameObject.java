package main;

abstract class GameObject {
    Boolean isMovable = true;
    int coordinateX;
    int coordinateY;
    Boolean isAlive;
    int size;

    abstract Boolean getIsMovable();
    abstract int getCoordinateX();
    abstract int getCoordinateY();
    abstract Boolean getIsAlive();
    abstract int getSize();

    abstract void setIsMovable();
    abstract void setCoordinateX();
    abstract void setCoordinateY();
    abstract void setIsAlive();
    abstract void setSize();
}