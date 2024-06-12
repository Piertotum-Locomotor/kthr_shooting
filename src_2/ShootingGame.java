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

class GamePanel extends JPanel implements MouseMotionListener {
    private Player player;

    public GamePanel() {
        player = new Player(10, 100, 100); // 初期位置（仮）
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        player.move(x, y);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    // 内部クラスとしてGameObjectを定義
    abstract class GameObject {
        protected int x, y;

        public GameObject(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // CharacterをGameObjectから派生
    abstract class Character extends GameObject {
        protected int size;

        public Character(int x, int y, int size) {
            super(x, y);
            this.size = size;
        }

        public abstract void draw(Graphics g);

        public void move(int newX, int newY) {
            x = newX;
            y = newY;
        }
    }

    // PlayerをCharacterから派生
    class Player extends Character {
        public Player(int size, int x, int y) {
            super(x, y, size);
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(x - size / 2, y - size / 2, size, size);
        }
    }
}
