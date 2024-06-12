import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Shooting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600); // 仮のサイズ
        frame.setVisible(true);

        GamePanel panel = new GamePanel();
        frame.add(panel);
    }



}
