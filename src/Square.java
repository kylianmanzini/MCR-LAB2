import java.awt.Image;
import java.awt.Color;

public class Square extends Shape {

    Square(int x, int y, int directionX, int directionY, int radius, Color color){
        super(x, y, directionX, directionY, radius, color);
    }

    @Override
    Image createImage() {
        return null;
    }
}
