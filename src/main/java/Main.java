import javax.swing.JFrame;

import javax.swing.*;

import GameRegistrer.GameRegistrer;
import gameobject.GameObject;
import gameobject.character.Character;
import gameobject.character.enemy.*;
import gameobject.character.player.Player;
import gameobject.ui.TextLabel;
import util.util;

import java.awt.*;
import java.awt.event.*;


public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shooting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setVisible(true);
        frame.setResizable(false);


        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.addKeyListener(panel);

        GameRegistrer.gameRegisterer( new Player(200, 500, 10, Color.BLUE, "PLAYER", 10, 0, -10, 10, 3) );
        GameRegistrer.gameRegisterer( new Boss(200, 100, 20, Color.RED, "BOSS", 20, 0, 10, 15, 100) );
    }
}


class GamePanel extends JPanel implements Runnable, KeyListener {
    Thread t;
    long frames;

    long error = 0;
    int fps = 60;
    long idealSleep = (1000 << 16) / fps;
    long oldTime;
    long newTime = System.currentTimeMillis() << 16;

    public GamePanel() {

        t = new Thread(this);
        t.start();
        frames = 0;

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                GameRegistrer.getObjects().get(0).move(x, y);   //プレイヤー
            }
        });
    }

    //毎フレーム実行
    public void run() {
        while(true) {
            oldTime = newTime;

            frames++;

            for (int i = 0; i < GameRegistrer.getObjects().size(); i++) {
                GameObject evaluating = GameRegistrer.getObjects().get(i);
    
                evaluating.task();
                evaluating.incrementTimer();

                // 衝突判定
                for (int j = 0; j < GameRegistrer.getObjects().size(); j++) {
                    if (i == j) continue;
                    GameObject evaluating2 = GameRegistrer.getObjects().get(j);
                    if (!(evaluating2 instanceof Character)) continue;

                    // evaluatingがevaluating2に衝突
                    if (util.dist(evaluating.getCoordinateX(), evaluating.getCoordinateY(), evaluating2.getCoordinateX(), evaluating2.getCoordinateY()) 
                                < evaluating.getSize()/2 + evaluating2.getSize()/2) {
                                    // evaluating2にダメージ
                                    Character evalChara2 = (Character)evaluating2;
                                    evalChara2.collided(evaluating);
                    }
                }

            }

            revalidate();   //コンポーネント再有効化
            repaint();  //再描画




            newTime = System.currentTimeMillis() << 16;
            long sleepTime = idealSleep - (newTime - oldTime) - error;
            if (sleepTime < 0x20000) sleepTime = 0x20000;
            oldTime = newTime;
            try {
                Thread.sleep(sleepTime >> 16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            newTime = System.currentTimeMillis() << 16;
            error = newTime - oldTime - sleepTime;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // テキストラベル
        TextLabel remaining = new TextLabel("", getWidth() - 10, getHeight() - 10, 20, 0, 0, Color.BLACK, Font.BOLD, 1);
        TextLabel gameObjectCount = new TextLabel("", 10, getHeight() - 10, 15, 0, 0, Color.BLACK, Font.PLAIN, 0);
        TextLabel bossHealth = new TextLabel("", getWidth()/2, 20, 15, 0, 0, Color.BLACK, Font.PLAIN, 0.5);

        for (int i = 0; i < GameRegistrer.getObjects().size(); i++) {
            GameObject evaluating = GameRegistrer.getObjects().get(i);
            // GameObject描画
            evaluating.draw(g);

            // テキストラベルの文字列
            // Playerを扱っているなら
            if (evaluating instanceof Player) {
                Player evalPlayer = (Player)evaluating;
                remaining.setStr("Remaining: " + evalPlayer.getRemaining());
            }
            // Bossを扱っているなら
            if (evaluating instanceof Boss) {
                Boss evalBoss = (Boss)evaluating;
                bossHealth.setStr("[DEBUG] Boss Health: " + evalBoss.getHealth());
            }
        }

        gameObjectCount.setStr("[DEBUG] GameObject Count: " + GameRegistrer.getObjects().size());

        // テキストラベル描画
        remaining.draw(g);
        gameObjectCount.draw(g);
        bossHealth.draw(g);
    }



    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {


        if (e.getKeyChar() == 'z') {
            GameObject temp = GameRegistrer.getObjects().get(0);
            Player player;
            if (temp instanceof Player) {
                player = (Player)temp;
                player.setTimer(0);
                player.setIsShooting(true);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


        if (e.getKeyChar() == 'z') {
            GameObject temp = GameRegistrer.getObjects().get(0);
            Player player;
            if (temp instanceof Player) {
                player = (Player)temp;
                player.setIsShooting(false);
            }
        }
    }


}