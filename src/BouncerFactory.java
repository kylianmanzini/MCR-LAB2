import java.awt.Color;

public abstract class BouncerFactory {

    abstract Circle createCircle(int x, int y, int diameter, int directionX, int directionY);

    abstract Square createSquare(int x, int y, int size, int directionX, int directionY);
}
