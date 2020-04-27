import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ReadInput extends KeyAdapter {
    GamePanel myPanel;

    public ReadInput(GamePanel myPanel){
        this.myPanel = myPanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        myPanel.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        myPanel.keyReleased(e);
    }
}