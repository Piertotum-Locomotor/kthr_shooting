package gameobject.ui;
import gameobject.GameObject;
import java.awt.*;

public class HPBar extends GameObject {
    private double value;

    public HPBar(int x, int y, int size, Color color, double value) {
        super(x, y, size, 0, 0, color);
        setValue(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    //仮だよ
    public void draw(Graphics g) {

        g.setColor(getColor());
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, (int)getValue(), super.getSize());
    }

    public void task() {
        setSize((int)getValue());
    }
}