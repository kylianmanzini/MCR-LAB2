import java.awt.Color;

public class NotFilledCircle extends Circle{
    NotFilledCircle(int x, int y, int directionX, int directionY, int diameter, Color color) {
        super(x, y, directionX, directionY, diameter, color);
    }

    @Override
    protected Renderer getRenderer() {
        return NotFilledRender.getInstance();
    }
}
