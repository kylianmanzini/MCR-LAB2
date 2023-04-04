package factory;

import bounceable.NotFilledCircle;
import bounceable.NotFilledSquare;

import java.awt.Color;

public class NotFilledFactory extends BouncerFactory {

    static private NotFilledFactory instance;

    private NotFilledFactory(){}

    /**
     * Create or return the NotFilledFactory instance
     */
    public static NotFilledFactory getInstance() {
        if (instance == null)
            instance = new NotFilledFactory();
        return instance;
    }

    @Override
    public NotFilledCircle createCircle(int x, int y, int diameter, int directionX, int directionY) {
        return new NotFilledCircle(x, y, directionX, directionY, diameter, Color.GREEN);
    }

    @Override
    public NotFilledSquare createSquare(int x, int y, int size, int directionX, int directionY) {
        return new NotFilledSquare(x, y, directionX, directionY, size, Color.RED);
    }
}
