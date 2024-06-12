import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Shooting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000); // 仮のサイズ
        frame.setVisible(true);

        GamePanel panel = new GamePanel();
        frame.add(panel);
    }



}
