import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyAdapter;

public class Display extends JFrame implements Displayer {

    private static Display instance;

    private Bouncer bouncer;

    private Display() {
        super();
        setSize(800,800);
        setVisible(true);
        //bouncer = new Circle(5, 5, 1, 1, 20, Color.BLACK);
        //add(bouncer);
    }

    public static Display getInstance() {
        if (instance == null) instance = new Display();
        return instance;
    }

    @Override
    public int getWidth() {
        return getContentPane().getWidth();

    }

    @Override
    public int getHeight() {
        return getContentPane().getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) super.getGraphics();
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public void addKeyListener(KeyAdapter ka) {

    }
}
