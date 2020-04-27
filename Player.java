import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {
    GamePanel myPanel;
    int x;
    int y;
    int width;
    int height;

    double xSpeed;
    double ySpeed;

    Rectangle hitBox;

    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;

    public Player(int x, int y, GamePanel myPanel) {
        this.myPanel = myPanel;
        this.x = x;
        this.y = y;

        width = 50;
        height = 50;
        hitBox = new Rectangle(x, y, width, height);
    }

    public void set(){
        if(keyLeft && keyRight || !keyLeft && !keyRight){
            xSpeed *= 0.8;
        }

        else if (keyLeft && !keyRight){
            xSpeed --;  
        }

        else if (keyRight && !keyLeft){
            xSpeed ++;
        }

        if(xSpeed > 0 && xSpeed < 0.75){
            xSpeed = 0;
        }

        if(xSpeed < 0 && xSpeed > -0.75){
            xSpeed = 0;
        }

        if(xSpeed > 9){
            xSpeed = 9;
        }

        if(xSpeed < -9){
            xSpeed = -9;
        }

        // Jumping
        if(keyUp){
            
            hitBox.y ++;
            for(Platform platform: myPanel.platforms){
                if(platform.hitBox.intersects(hitBox)){
                    ySpeed = -14;
                }
            }
            hitBox.y --;
        }

        // Fastfall
        if(keyDown){
            ySpeed += 2;
        }

        // Gravity
        ySpeed += 0.8;

        // Horizontal Collision
        hitBox.x += xSpeed;
        for(Platform platform: myPanel.platforms){
            if(hitBox.intersects(platform.hitBox)){
                hitBox.x -= xSpeed;
                while(!platform.hitBox.intersects(hitBox)) hitBox.x += Math.signum(xSpeed);
                hitBox.x -= Math.signum(xSpeed);
                xSpeed = 0;
                x = hitBox.x;
            }
        }

        // Vertical Collision
        hitBox.y += ySpeed;
        for(Platform platform: myPanel.platforms){
            if(hitBox.intersects(platform.hitBox)){
                hitBox.y -= ySpeed;
                while(!platform.hitBox.intersects(hitBox)) hitBox.y += Math.signum(ySpeed);
                hitBox.y -= Math.signum(ySpeed);
                ySpeed = 0;
                y = hitBox.y;
            }
        }

        x += xSpeed;
        y += ySpeed;

        hitBox.x = x;
        hitBox.y = y;
    }

    public void draw(Graphics2D gtd){
        gtd.setColor(Color.BLUE);
        gtd.fillRect(x, y, width, height);
    }
}