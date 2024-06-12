import javax.swing.JFrame;

import GameRegistrer.GameRegistrer;
import gameobject.character.enemy.Boss;
import gameobject.character.player.Player;
import gameobject.ui.GamePanel;


public class Main {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Shooting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000); // 仮のサイズ
        frame.setVisible(true);



        GameRegistrer.gameRegisterer( new Player(10, 100, 10, "PLAYER", 10, 0, -5) ); // 初期位置（仮
        GameRegistrer.gameRegisterer( new Boss(500, 500, 20, "BOSS", 20, 0, 10) );



        GamePanel panel = new GamePanel();
        frame.add(panel);
    }
}
