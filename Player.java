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
    boolean keyUp;
    boolean keyLeft;
    boolean keyDown;
    boolean keyRight;
    Rectangle hitBox;

    public Player(int x, int y, GamePanel myPanel) {
        this.myPanel = myPanel;
        this.x = x;
        this.y = y;
        width = 50;
        height = 50;

        // The hitbox is used to check the collision between the player and the wall.
        hitBox = new Rectangle(x, y, width, height);
    }

    public void set(){
        if(keyLeft && keyRight || !keyLeft && !keyRight){
            xSpeed = xSpeed * 0.8;
        }

        else if (keyLeft && !keyRight){
            xSpeed = xSpeed - 1;  
        }

        else if (keyRight && !keyLeft){
            xSpeed = xSpeed + 1;
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
            hitBox.y = hitBox.y + 1;
            for(Platform platform: myPanel.platforms){
                if(platform.hitBox.intersects(hitBox)){
                    ySpeed = -14;
                }
            }
            hitBox.y = hitBox.y - 1;
        }

        // Fastfall
        if(keyDown){
            ySpeed = ySpeed + 2;
        }

        // Gravity
        ySpeed = ySpeed + 0.8;

        // Horizontal and Vertical Collision code from Youtube Channel Matthew Bellavia.
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

        // This allows the screen to scroll horizontally.
        myPanel.camera -= xSpeed;
        y += ySpeed;

        hitBox.x = x;
        hitBox.y = y;
    }

    public void draw(Graphics2D g2D){
        g2D.setColor(Color.BLUE);
        g2D.fillRect(x, y, width, height);
    }
}