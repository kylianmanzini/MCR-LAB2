import java.awt.Color;
import java.awt.Image;

public class Circle extends Shape {

    protected int radius;

    Circle(int x, int y, int directionX, int directionY, int radius, Color color) {
        super(x, y, directionX, directionY, color);
        this.radius = radius;
    }

    @Override
    Image createImage() {
        return null;
    }
}
