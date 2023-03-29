import java.awt.*;

public class NotFilledSquare extends Square{
    NotFilledSquare(int x, int y, int directionX, int directionY, int length, Color color) {
        super(x, y, directionX, directionY, length, color);
    }

    @Override
    protected Renderer getRenderer() {
        return null;
    }
}
