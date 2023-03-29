import java.awt.*;
import java.util.Vector;

abstract public class Bouncer implements Bouncable{

    protected int directionX;
    protected int directionY;
    protected int x;
    protected int y;

    protected Color color;

    Bouncer(int x, int y, int directionX, int directionY, Color color) {
        this.directionX = directionX;
        this.directionY = directionY;
        this.x = x;
        this.y = y;
        this.color = color;
    }
    Bouncer(Vector<Integer> position, Vector<Integer> direction, Color color) {
        if (position.capacity() != 2 || direction.capacity() != 2)
            throw new RuntimeException("position and direction must be vector of size 2. (x, y)");
        this.directionX = direction.elementAt(0);
        this.directionY = direction.elementAt(1);
        this.x = position.elementAt(0);
        this.y = position.elementAt(1);
        this.color = color;
    }

    @Override
    public void move() {
        x += directionX;
        y += directionY;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
    @Override
    public void draw() {
        getRenderer().display(Display.getInstance().getGraphics(), this);
    }

    protected abstract Renderer getRenderer();

}

