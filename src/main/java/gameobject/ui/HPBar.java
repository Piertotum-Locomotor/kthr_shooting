package gameobject.ui;
import gameobject.GameObject;
import java.awt.*;

public class HPBar extends GameObject {
    private double value;
    private double maxValue;

    public HPBar(int x, int y, int size, Color color, double value) {
        super(x, y, size, 0, 0, color);
        this.value = value;
        this.maxValue = value;
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
        int width = (int)((value/maxValue) * super.getSize());
        g.fillRect(super.getCoordinateX(), super.getCoordinateY(), width, 10);
    }

    public void task() {
        //setSize((int)getValue());
    }    
}