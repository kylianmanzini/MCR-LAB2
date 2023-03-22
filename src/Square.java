import java.awt.*;

public abstract class Square extends Bouncer {

    protected int length;

    Square(int x, int y, int directionX, int directionY, int length, Color color) {
        super(x, y, directionX, directionY, color);
        this.length = length;
    }

    @Override
    public void draw() {

    }

    @Override
    public void move() {

    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Shape getShape() {
        return null;
    }
}
