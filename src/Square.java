import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Square extends Bouncer {

    protected int length;

    Square(int x, int y, int directionX, int directionY, int length, Color color) {
        super(x, y, directionX, directionY, color);
        this.length = length;
    }

    @Override
    public Rectangle2D.Double getShape() {
        return new Rectangle2D.Double(x,y,length,length);
    }
}
