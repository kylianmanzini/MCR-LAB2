import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Circle extends Bouncer {

    protected int diameter;

    Circle(int x, int y, int directionX, int directionY, int diameter, Color color) {
        super(x, y, directionX, directionY, color);
        this.diameter = diameter;
    }

    @Override
    public void check(int width, int height){
        if (x <= 0 || x >= width - diameter){
            directionX = -directionX;
        }
        if (y <= 0 || y >= height - diameter){
            directionY = -directionY;
        }
    }


    @Override
    public Ellipse2D.Double getShape() {
        return new Ellipse2D.Double(x,y,diameter,diameter);
    }
}
