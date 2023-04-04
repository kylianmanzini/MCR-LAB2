package bounceable;

import display.renderer.Renderer;
import display.renderer.NotFilledRender;
import java.awt.*;

public class NotFilledSquare extends Square{
    public NotFilledSquare(int x, int y, int directionX, int directionY, int length, Color color) {
        super(x, y, directionX, directionY, length, color);
    }

    @Override
    protected Renderer getRenderer() {
        return NotFilledRender.getInstance();
    }
}
