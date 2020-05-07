import java.awt.Color;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
    
    public GameFrame() {
    GamePanel myPanel = new GamePanel();
    myPanel.setLocation(0,0);
    myPanel.setSize(this.getSize());
    myPanel.setBackground(Color.CYAN);
    myPanel.setVisible(true);
    this.add(myPanel);
    addKeyListener(new ReadInput(myPanel));
    }    
}