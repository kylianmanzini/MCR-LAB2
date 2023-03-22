import javax.swing.JPanel;
import java.awt.*;
import java.util.Vector;

abstract public class Bouncer implements Bouncable{

    protected Vector<Integer> direction;
    protected int x;
    protected int y;

    protected Color color;

    Bouncer(int x, int y, int directionX, int directionY, Color color) {
        direction = new Vector<>();
        direction.add(0, directionX);
        direction.add(1, directionY);
        this.x = x;
        this.y = y;
        this.color = color;
    }


}

