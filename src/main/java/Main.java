import javax.swing.JFrame;

import javax.swing.*;

import GameRegistrer.GameRegistrer;
import gameobject.GameObject;
import gameobject.character.Character;
import gameobject.character.enemy.*;
import gameobject.character.player.Player;

import java.awt.*;
import java.awt.event.*;


public class Main {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Shooting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000); // 仮のサイズ
        frame.setVisible(true);
        frame.setResizable(false);


        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.addKeyListener(panel);

        GameRegistrer.gameRegisterer( new Player(10, 100, 10, Color.BLUE, "PLAYER", 10, 0, -10, 10) );
        GameRegistrer.gameRegisterer( new Boss(500, 500, 20, Color.RED, "BOSS", 20, 0, 10, 15) );
    }
}


class GamePanel extends JPanel implements Runnable, KeyListener {
    Thread t;
    int frames;

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

                // Characterを扱っているなら
                if (evaluating instanceof Character) {
                    Character evalChara = (Character)evaluating;
                    
                }

                repaint();
            }




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

        for (int i = 0; i < GameRegistrer.getObjects().size(); i++) {
            GameRegistrer.getObjects().get(i).draw(g);
        }
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