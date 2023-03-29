import java.awt.Color;

public class FilledFactory extends BouncerFactory {

    static FilledFactory instance;

    private FilledFactory(){}

    public static FilledFactory getInstance() {
        if (instance == null)
            instance = new FilledFactory();
        return instance;
    }

    @Override
    FilledCircle createCircle(int x, int y, int diameter, int directionX, int directionY) {
        return new FilledCircle(x, y, directionX, directionY, diameter, Color.BLUE);
    }

    @Override
    FilledSquare createSquare(int x, int y, int size, int directionX, int directionY) {
        return new FilledSquare(x, y, directionX, directionY, size, Color.ORANGE);
    }
}
