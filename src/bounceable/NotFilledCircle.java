package bounceable;

import display.renderer.Renderer;
import display.renderer.NotFilledRender;

import java.awt.Color;

public class NotFilledCircle extends Circle{
    public NotFilledCircle(int x, int y, int directionX, int directionY, int diameter, Color color) {
        super(x, y, directionX, directionY, diameter, color);
    }

    @Override
    protected Renderer getRenderer() {
        return NotFilledRender.getInstance();
    }
}
