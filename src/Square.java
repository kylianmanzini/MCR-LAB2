import java.awt.Color;
import java.awt.geom.Rectangle2D;

public abstract class Square extends Bouncer {

    protected int length;

    Square(int x, int y, int directionX, int directionY, int length, Color color) {
        super(x, y, directionX, directionY, color);
        this.length = length;
    }

    @Override
    public void check(int width, int height){
        if (x <= 0 || x >= width - length){
            directionX = -directionX;
        }
        if (y <= 0 || y >= height - length){
            directionY = -directionY;
        }
    }

    @Override
    public Rectangle2D.Double getShape() {
        return new Rectangle2D.Double(x,y,length,length);
    }
}
