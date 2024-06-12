package gameobject.character.enemy;
import java.awt.*;

public class Boss extends Enemy {

    public Boss(int x, int y, int size, String name, double bulletOffence, double bulletVelocity) {
        super(x, y, size, name, bulletOffence, bulletVelocity);
    }

    //仮だよ
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }

}