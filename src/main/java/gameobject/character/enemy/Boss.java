package gameobject.character.enemy;
import java.awt.*;

public class Boss extends Enemy {

    public Boss(int x, int y, int size) {
        super(x, y, size);
    }

    //仮だよ
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(super.getCoordinateX() - super.getSize() / 2, super.getCoordinateY() - super.getSize() / 2, super.getSize(), super.getSize());
    }

}