package bounceable;

import java.awt.Color;
import java.awt.Shape;

public interface Bounceable {
    void draw();
    void move(int width, int height);
    Color getColor();
    Shape getShape();

}