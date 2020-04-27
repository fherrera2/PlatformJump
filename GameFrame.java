import java.awt.Color;

public class GameFrame extends javax.swing.JFrame{
    
    public GameFrame() {
    GamePanel myPanel = new GamePanel();
    myPanel.setLocation(0,0);
    myPanel.setSize(this.getSize());
    myPanel.setBackground(Color.LIGHT_GRAY);
    myPanel.setVisible(true);
    this.add(myPanel);
    addKeyListener( new ReadInput(myPanel));
    }    
}