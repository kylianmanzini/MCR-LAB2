import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

abstract public class Shape extends JPanel {

    ArrayList<Integer> direction;
    int radius;
    int x;
    int y;

    Color color;

    Shape(int x, int y, int directionX, int directionY, int radius, Color color){
        direction.set(0, directionX);
        direction.set(1, directionY);
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    abstract Image createImage();

}

