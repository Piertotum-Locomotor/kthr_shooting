package main;

import java.awt.*;

public class Zako extends Enemy{

    public Zako(int x, int y, int size) {
        super(x, y, size);
    }

    //仮だよ
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }
    
}