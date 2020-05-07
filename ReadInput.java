import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ReadInput extends KeyAdapter {
    GamePanel myPanel;

    public ReadInput(GamePanel myPanel){
        this.myPanel = myPanel;
    }

    public void keyPressed(KeyEvent e) {
        myPanel.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        myPanel.keyReleased(e);
    }
}