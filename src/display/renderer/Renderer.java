package display.renderer;

import bounceable.Bounceable;

import java.awt.Graphics2D;

public interface Renderer {
    void display(Graphics2D g, Bounceable b);
}