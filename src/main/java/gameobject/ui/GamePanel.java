package gameobject.ui;

import javax.swing.*;

import GameRegistrer.GameRegistrer;
import gameobject.GameObject;
import gameobject.character.Character;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {
    

    public GamePanel() {
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                GameRegistrer.getObjects().get(0).move(x, y);   //プレイヤー
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < GameRegistrer.getObjects().size(); i++) {
            GameObject evaluating = GameRegistrer.getObjects().get(i);

            evaluating.move(evaluating.getCoordinateX() + evaluating.getVelocityX(), evaluating.getCoordinateY() + evaluating.getVelocityY());
            evaluating.draw(g);

            // Characterを扱っているなら
            if (evaluating instanceof Character) {
                Character evalChara = (Character)evaluating;

                if (true) {
                    evalChara.shoot(10, 10);
                }
            }
        }
    }
}