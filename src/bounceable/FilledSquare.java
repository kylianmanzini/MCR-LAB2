package bounceable;

import display.renderer.FilledRender;
import display.renderer.Renderer;

import java.awt.Color;

public class FilledSquare extends Square {
    public FilledSquare(int x, int y, int directionX, int directionY, int length, Color color) {
        super(x, y, directionX, directionY, length, color);
    }

    @Override
    protected Renderer getRenderer() {
        return FilledRender.getInstance();
    }
}
