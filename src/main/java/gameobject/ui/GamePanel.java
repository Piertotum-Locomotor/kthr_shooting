package gameobject.ui;

import gameobject.character.player.Player;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {
    private Player player;

    public GamePanel() {
        player = new Player(10, 100, 10, "PLAYER", 10, 5); // 初期位置（仮）

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