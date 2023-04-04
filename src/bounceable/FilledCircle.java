package bounceable;

import display.renderer.FilledRender;
import display.renderer.Renderer;

import java.awt.Color;

public class FilledCircle extends Circle{
    public FilledCircle(int x, int y, int directionX, int directionY, int diameter, Color color) {
        super(x, y, directionX, directionY, diameter, color);
    }

    @Override
    protected Renderer getRenderer() {
        return FilledRender.getInstance();
    }
}
