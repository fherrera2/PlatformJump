import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Platform {
    int x;
    int beginX;
    int y;
    int width;
    int height;
    Rectangle hitBox;
    
    public Platform(int x, int y, int width, int height){
        this.x = x;
        beginX = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitBox = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D g2D){
        g2D.setColor(Color.BLACK);
        g2D.drawRect(x, y, width, height);
        g2D.setColor(Color.PINK);
        g2D.fillRect(x+1, y+1, width-2, height-2);
    }
    
    public int set(int camera) {
        x = beginX + camera;
        hitBox.x = x;
        return x;
    }
}