package factory;

import bounceable.Circle;
import bounceable.Square;

public abstract class BouncerFactory {
    public abstract Circle createCircle(int x, int y, int diameter, int directionX, int directionY);
    public abstract Square createSquare(int x, int y, int size, int directionX, int directionY);
}
