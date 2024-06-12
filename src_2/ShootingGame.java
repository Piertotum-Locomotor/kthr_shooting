import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShootingGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Shooting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600); // 仮のサイズ
        frame.setVisible(true);

        GamePanel panel = new GamePanel();
        frame.add(panel);
    }
}

abstract class GameObject {
    protected int x, y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Character extends GameObject {
    protected int size;

    public Character(int x, int y, int size) {
        super(x, y);
        this.size = size;
    }

    public void draw(Graphics g) {
        // このメソッドは具象メソッドとして定義されていますが、
        // サブクラスでオーバーライドすることができます
    }

    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }
}

class Player extends Character {
    public Player(int size, int x, int y) {
        super(x, y, size);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x - size / 2, y - size / 2, size, size);
    }
}

class GamePanel extends JPanel {
    private Player player;

    public GamePanel() {
        player = new Player(10, 100, 100); // 初期位置（仮）
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                player.move(x, y);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }
}
