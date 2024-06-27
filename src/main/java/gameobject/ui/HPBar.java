package gameobject.ui;
import gameobject.GameObject;
import java.awt.*;

public class HPBar extends GameObject {
    private double value;
    private double maxValue;

    public HPBar(int x, int y, int size, Color color, double value) {
        super(x, y, size, 0, 0, color);
        setValue(value);
        setMaxValue(value);
    }

    public double getValue() {
        return value;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }
    
    public void draw(Graphics g) {

        g.setColor(getColor());
        int width = (int)((value/maxValue) * super.getSize());
        g.fillRect(super.getCoordinateX(), super.getCoordinateY(), width, 10);
    }

    public void task() {
    }    
}