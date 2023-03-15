import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.util.Vector;

abstract public class Shape extends JPanel {

    protected Vector<Integer> direction;
    protected int x;
    protected int y;

    protected Color color;

    Shape(int x, int y, int directionX, int directionY, Color color) {
        direction.set(0, directionX);
        direction.set(1, directionY);
        this.x = x;
        this.y = y;
        this.color = color;
    }

    abstract Image createImage();

}

