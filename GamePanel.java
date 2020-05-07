import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
    Player gamer;
    Timer gameTimer;
    int camera;
    ArrayList<Platform> platforms = new ArrayList<>();

    public GamePanel(){
        gamer = new Player(350, 500, this);
        camera = 200;
        makePlatforms();

        // Begins the in-game timer and sets it to increment a second at about 60 frames.
        // Credit to Youtube Channel Matthew Bellavia for this part of the code.
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask(){
            
            public void run() {
                gamer.set();
                for(Platform platform: platforms){
                    platform.set(camera);
                }
                repaint();
            }
        }, 0, 17);
    }

    public void makePlatforms(){

        // Creates the level where the player can move around.
        for (int i = 0; i < 2050; i+= 50){
            platforms.add(new Platform(i, 650, 50, 50));
        }
        for (int i = 0; i < 650; i+= 50){
            platforms.add(new Platform(0, i, 50, 50));
        }
        for (int i = 150; i < 650; i+= 50){
            platforms.add(new Platform(700, i, 50, 50));
        }
        for (int i = 0; i < 2050; i += 50){
            platforms.add(new Platform(i, 0, 50, 50));
        }
        for (int i = 0; i < 600; i += 50){
            platforms.add(new Platform(800, i, 50, 50));
        }
        for (int i = 150; i < 650; i += 50){
            platforms.add(new Platform(1100, i, 50, 50));
        }
        for (int i = 50; i < 600; i += 50){
            platforms.add(new Platform(1300, i, 50, 50));
        }
        for (int i = 100; i < 700; i += 50){
            platforms.add(new Platform(1900, i, 50, 50));
        }
        for (int i = 50; i < 700; i += 50){
            platforms.add(new Platform(2000, i, 50, 50));
        }
        // Individual blocks for first part of level
        platforms.add(new Platform(700, 0, 50, 50));
        platforms.add(new Platform(750, 0, 50, 50));
        platforms.add(new Platform(50, 550, 50, 50));
        platforms.add(new Platform(100, 550, 50, 50));
        platforms.add(new Platform(250, 450, 50, 50));
        platforms.add(new Platform(250, 350, 50, 50));
        platforms.add(new Platform(450, 250, 50, 50));
        platforms.add(new Platform(600, 150, 50, 50));
        platforms.add(new Platform(650, 150, 50, 50));
        platforms.add(new Platform(650, 350, 50, 50));
        platforms.add(new Platform(650, 550, 50, 50));
        platforms.add(new Platform(450, 450, 50, 50));
        
        // Individual blocks for second part of level
        platforms.add(new Platform(850, 550, 50, 50));
        platforms.add(new Platform(950, 450, 50, 50));
        platforms.add(new Platform(1050, 350, 50, 50));
        platforms.add(new Platform(950, 250, 50, 50));

        // Individual blocks for third part of level
        platforms.add(new Platform(1150, 150, 50, 50));
        platforms.add(new Platform(1200, 150, 50, 50));
        platforms.add(new Platform(1200, 300, 50, 50));
        platforms.add(new Platform(1250, 300, 50, 50));
        platforms.add(new Platform(1150, 450, 50, 50));
        platforms.add(new Platform(1200, 450, 50, 50));
        platforms.add(new Platform(1250, 550, 50, 50));
        platforms.add(new Platform(1200, 550, 50, 50));

        // Individual blocks for final part of level
        platforms.add(new Platform(1850, 550, 50, 50));
        platforms.add(new Platform(1700, 450, 50, 50));
        platforms.add(new Platform(1550, 350, 50, 50));
        platforms.add(new Platform(1400, 250, 50, 50));
        platforms.add(new Platform(1550, 150, 50, 50));
        platforms.add(new Platform(1700, 200, 50, 50));
        platforms.add(new Platform(1850, 100, 50, 50));

    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        gamer.draw(g2D);
        
        for(Platform platform: platforms){
            platform.draw(g2D);
        }
    }
    
    void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w') gamer.keyUp = true;
        if(e.getKeyChar() == 'a') gamer.keyLeft = true;
        if(e.getKeyChar() == 's') gamer.keyDown = true;
        if(e.getKeyChar() == 'd') gamer.keyRight = true;
    }

    void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'w') gamer.keyUp = false;
        if(e.getKeyChar() == 'a') gamer.keyLeft = false;
        if(e.getKeyChar() == 's') gamer.keyDown = false;
        if(e.getKeyChar() == 'd') gamer.keyRight = false;
    }

    public void actionPerformed(ActionEvent ae) {
    }
}