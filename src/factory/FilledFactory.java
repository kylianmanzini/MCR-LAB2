package factory;

import bounceable.FilledCircle;
import bounceable.FilledSquare;

import java.awt.Color;

public class FilledFactory extends BouncerFactory {

    static private FilledFactory instance;

    private FilledFactory(){}

    /**
     * Create or return the FilledFactory instance
     */
    public static FilledFactory getInstance() {
        if (instance == null)
            instance = new FilledFactory();
        return instance;
    }

    @Override
    public FilledCircle createCircle(int x, int y, int diameter, int directionX, int directionY) {
        return new FilledCircle(x, y, directionX, directionY, diameter, Color.BLUE);
    }

    @Override
    public FilledSquare createSquare(int x, int y, int size, int directionX, int directionY) {
        return new FilledSquare(x, y, directionX, directionY, size, Color.ORANGE);
    }
}
