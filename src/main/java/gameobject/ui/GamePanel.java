package gameobject.ui;

import gameobject.character.player.Player;
import gameobject.GameObject;
import gameobject.character.enemy.Boss;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {
    private GameObject objects[] = new GameObject[1024];

    public GamePanel() {
        objects[0] = new Player(10, 100, 10, "PLAYER", 10, 5); // 初期位置（仮）
        objects[1] = new Boss(500, 500, 20, "BOSS", 20, 10);

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                objects[0].move(x, y);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        objects[0].draw(g);
        objects[1].draw(g);
    }
}