import java.awt.Color;
import java.awt.geom.Ellipse2D;

public abstract class Circle extends Bouncer {

    protected int diameter;

    Circle(int x, int y, int directionX, int directionY, int diameter, Color color) {
        super(x, y, directionX, directionY, color);
        this.diameter = diameter;
    }

    @Override
    public void check(int width, int height){
        if (x < 0){
            directionX = -directionX;
            x = 0;
        }
        if (x > width - diameter){
            directionX = -directionX;
            x = width - diameter;
        }
        if (y < 0){
            directionY = -directionY;
            y = 0;
        }
        if (y > height - diameter){
            directionY = -directionY;
            y = height - diameter;
        }
    }


    @Override
    public Ellipse2D.Double getShape() {
        return new Ellipse2D.Double(x,y,diameter,diameter);
    }
}
