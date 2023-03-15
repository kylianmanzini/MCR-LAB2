import javax.swing.JPanel;
import java.awt.*;
import java.util.Vector;

abstract public class Shape extends JPanel {

    protected Vector<Integer> direction;
    protected int x;
    protected int y;

    protected Color color;

    Shape(int x, int y, int directionX, int directionY, Color color) {
        direction = new Vector<>();
        direction.add(0, directionX);
        direction.add(1, directionY);
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void paint(Graphics g) {
        super.paint(g);
        x += direction.get(0);
        y += direction.get(1);
    }

}

