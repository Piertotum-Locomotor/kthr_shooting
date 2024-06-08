import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Player {
    private int x, y;
    private int health;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.health = 100; // プレイヤーの体力
    }

    public void move(int mouseX, int mouseY) {
        this.x = mouseX;
        this.y = mouseY;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 20, 20); // プレイヤーを描画
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;
    }
}

class Enemy {
    private int x, y;
    private int health;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.health = 200; // 大きな敵の体力
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50); // 大きな敵を描画
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;
    }

    public int getHealth() {
        return health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void attack(java.util.List<Bullet> bullets) {
        bullets.add(new Bullet(x + 25, y + 50, true)); // 敵が攻撃する
    }
}

class Bullet {
    private int x, y;
    private final int speed = 5;
    private boolean playerBullet; // プレイヤーの玉かどうかを表すフラグ

    public Bullet(int x, int y, boolean playerBullet) {
        this.x = x;
        this.y = y;
        this.playerBullet = playerBullet;
    }

    public void move() {
        if (playerBullet) {
            y -= speed; // プレイヤーの玉は上に移動
        } else {
            y += speed; // 敵の玉は下に移動
        }
    }

    public void draw(Graphics g) {
        g.setColor(playerBullet ? Color.BLACK : Color.GREEN); // プレイヤーの玉は黒、敵の玉は緑
        g.fillOval(x, y, 5, 5); // 弾を描画
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isPlayerBullet() {
        return playerBullet;
    }
}

public class ShootingGame extends JPanel implements MouseMotionListener, MouseListener {
    private Player player;
    private Enemy enemy;
    private Timer timer;
    private java.util.List<Bullet> bullets;

    public ShootingGame() {
        player = new Player(300, 400); // プレイヤーの初期位置
        enemy = new Enemy(300, 50); // 大きな敵の初期位置
        bullets = new java.util.ArrayList<>();

        timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
                repaint();
            }
        });
        timer.start();

        addMouseMotionListener(this);
        addMouseListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        enemy.draw(g);
        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
    }

    public void mouseMoved(MouseEvent e) {
        player.move(e.getX(), e.getY());
    }

    public void mouseDragged(MouseEvent e) {
        // ドラッグされた時の処理
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) { // 左クリックの場合
            bullets.add(new Bullet(player.getX() + 10, player.getY(), true)); // プレイヤーが攻撃する
        }
    }

    public void mousePressed(MouseEvent e) {
        // マウスが押された時の処理
    }

    public void mouseReleased(MouseEvent e) {
        // マウスが離された時の処理
    }

    public void mouseEntered(MouseEvent e) {
        // マウスがコンポーネント内に入った時の処理
    }

    public void mouseExited(MouseEvent e) {
        // マウスがコンポーネント外に出た時の処理
    }

    private void update() {
        // 敵の移動や弾の当たり判定などを行う
        for (Bullet bullet : bullets) {
            bullet.move();
            if (bullet.getY() < 0 || bullet.getY() > getHeight()) {
                bullets.remove(bullet);
                break;
            }
            if (bullet.isPlayerBullet() && bullet.getX() >= enemy.getX() && bullet.getX() <= enemy.getX() + 50 &&
                    bullet.getY() >= enemy.getY() && bullet.getY() <= enemy.getY() + 50) {
                enemy.decreaseHealth(10); // プレイヤーの弾が敵に当たった時の処理
                bullets.remove(bullet);
                if (enemy.getHealth() <= 0) {
                    // 敵を倒した時の処理
                }
                break;
            }
        }
        enemy.attack(bullets); // 敵が攻撃する
        // 敵の攻撃やプレイヤーとの当たり判定などを行う
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shooting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new ShootingGame());
        frame.setVisible(true);
    }
}
