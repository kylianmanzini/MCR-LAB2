import java.awt.*;

public class Circle extends Shape {

    protected int diameter;

    Circle(int x, int y, int directionX, int directionY, int diameter, Color color) {
        super(x, y, directionX, directionY, color);
        this.diameter = diameter;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
}
