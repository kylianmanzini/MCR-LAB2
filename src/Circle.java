import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Circle extends Bouncer {

    protected int diameter;

    Circle(int x, int y, int directionX, int directionY, int diameter, Color color) {
        super(x, y, directionX, directionY, color);
        this.diameter = diameter;
    }

    @Override
    public void draw() {

    }

    @Override
    public void move() {

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(x,y,diameter,diameter);
    }
}
