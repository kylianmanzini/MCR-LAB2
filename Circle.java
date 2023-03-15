import java.awt.*;

public class Circle extends Shape {

    Circle(int x, int y, int directionX, int directionY, int radius, Color color){
        super(x, y, directionX, directionY, radius, color);
    }

    @Override
    Image createImage() {
        return null;
    }
}
