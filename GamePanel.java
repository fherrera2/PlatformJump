import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



public class GamePanel extends javax.swing.JPanel implements ActionListener{
    Player gamer;
    ArrayList<Platform> platforms = new ArrayList<>();
    Timer gameTimer;

    public GamePanel(){
        gamer = new Player(400, 300, this);

        makePlatforms();

        // Begins the in-game timer and sets it to increment a second at about 60 frames.
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask(){
            
            @Override
            public void run() {
                gamer.set();
                repaint();
            }
        }, 0, 17);
    }

    public void makePlatforms(){
        for (int i = 0; i < 750; i+= 50){
            platforms.add(new Platform(i, 600, 50, 50));
        }
        for (int i = 0; i < 600; i+= 50){
            platforms.add(new Platform(0, i, 50, 50));
        }
        for (int i = 0; i < 600; i+= 50){
            platforms.add(new Platform(700, i, 50, 50));
        }
        platforms.add(new Platform(50, 500, 50, 50));
        platforms.add(new Platform(100, 500, 50, 50));
        platforms.add(new Platform(250, 400, 50, 50));
        platforms.add(new Platform(250, 300, 50, 50));
        platforms.add(new Platform(450, 200, 50, 50));
        platforms.add(new Platform(600, 100, 50, 50));
        platforms.add(new Platform(650, 100, 50, 50));
        platforms.add(new Platform(650, 300, 50, 50));
        platforms.add(new Platform(650, 500, 50, 50));
        platforms.add(new Platform(450, 400, 50, 50));
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        gamer.draw(gtd);
        
        for(Platform platform: platforms){
            platform.draw(gtd);
        }
    }
    
    void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a') gamer.keyLeft = true;
        if(e.getKeyChar() == 'w') gamer.keyUp = true;
        if(e.getKeyChar() == 'd') gamer.keyRight = true;
        if(e.getKeyChar() == 's') gamer.keyDown = true;
    }

    void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a') gamer.keyLeft = false;
        if(e.getKeyChar() == 'w') gamer.keyUp = false;
        if(e.getKeyChar() == 'd') gamer.keyRight = false;
        if(e.getKeyChar() == 's') gamer.keyDown = false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

}