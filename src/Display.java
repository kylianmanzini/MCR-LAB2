import javax.swing.JFrame;
import java.awt.Graphics2D;

public class Display extends JFrame implements Displayer {

    private static Display instance;

    private Display() {
    }

    public static Display getInstance() {
        if (instance == null) instance = new Display();
        return instance;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public Graphics2D getGraphics() {
        return null;
    }

    @Override
    public void repaint() {

    }

    @Override
    public void setTitle(String title) {

    }
}
