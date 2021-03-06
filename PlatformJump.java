import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.WindowConstants;

public class PlatformJump {
    public static void main(String[] args) {
        System.out.println("PlatformJump Starting...");
        GameFrame myFrame = new GameFrame();
        myFrame.setSize(750,750);
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        myFrame.setLocation((int)(screenDimension.getWidth()/2 - myFrame.getSize().getWidth()/2),
        (int)(screenDimension.getHeight()/2- myFrame.getSize().getHeight()/2));
        
        // User cannot resize window as this would cause problems for the game.
        myFrame.setResizable(false);
        myFrame.setTitle("PlatformJump");
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}