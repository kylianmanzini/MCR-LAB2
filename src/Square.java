import java.awt.Image;
import java.awt.Color;

public class Square extends Shape {

    protected int length;

    Square(int x, int y, int directionX, int directionY, int length, Color color) {
        super(x, y, directionX, directionY, color);
        this.length = length;
    }

    @Override
    Image createImage() {
        return null;
    }
}
