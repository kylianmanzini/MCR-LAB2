import java.awt.*;

public class FilledCircle extends Circle{
    FilledCircle(int x, int y, int directionX, int directionY, int diameter, Color color) {
        super(x, y, directionX, directionY, diameter, color);
    }


    @Override
    protected Renderer getRenderer() {
        return FilledRender.getInstance();
    }
}
