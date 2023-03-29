import java.awt.Color;

public class NotFilledFactory extends BouncerFactory {

    static NotFilledFactory instance;

    private NotFilledFactory(){}

    public static NotFilledFactory getInstance() {
        if (instance == null)
            instance = new NotFilledFactory();
        return instance;
    }

    @Override
    NotFilledCircle createCircle(int x, int y, int diameter, int directionX, int directionY) {
        return new NotFilledCircle(x, y, directionX, directionY, diameter, Color.GREEN);
    }

    @Override
    NotFilledSquare createSquare(int x, int y, int size, int directionX, int directionY) {
        return new NotFilledSquare(x, y, directionX, directionY, size, Color.RED);
    }
}
