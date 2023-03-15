import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Square extends Shape {

    protected int length;

    Square(int x, int y, int directionX, int directionY, int length, Color color) {
        super(x, y, directionX, directionY, color);
        this.length = length;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        g.fillRect(x, y, length, length);
    }
}
