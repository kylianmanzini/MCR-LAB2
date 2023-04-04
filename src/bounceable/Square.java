package bounceable;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public abstract class Square extends Bouncer {

    private final int length;

    Square(int x, int y, int directionX, int directionY, int length, Color color) {
        super(x, y, directionX, directionY, color);
        this.length = length;
    }

    @Override
    protected void bounceChecker(int width, int height){
        if (x < 0){
            directionX = -directionX;
            x = 0;
        }
        if (x > width - length){
            directionX = -directionX;
            x = width - length;
        }
        if (y < 0){
            directionY = -directionY;
            y = 0;
        }
        if (y > height - length){
            directionY = -directionY;
            y = height - length;
        }
    }

    @Override
    public Rectangle2D.Double getShape() {
        return new Rectangle2D.Double(x,y,length,length);
    }
}
