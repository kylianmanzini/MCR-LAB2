import javax.swing.*;
import java.awt.*;

public class Display extends JFrame implements Displayer{


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
