
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;

public class Display implements Displayer {

    static final int WINDOW_SIZE = 500;
    static final int MIN_HEIGHT = 100;
    static final int MIN_WIDTH = 200;
    private static Display instance;
    private final JPanel panel;
    public final JFrame frame;
    private Image image;


    private Display() {
        frame = new JFrame();
        frame.setSize(WINDOW_SIZE,WINDOW_SIZE);
        frame.setMinimumSize(new Dimension(MIN_WIDTH,MIN_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setSize(WINDOW_SIZE,WINDOW_SIZE);
        frame.setContentPane(panel);

        frame.setVisible(true);

        image = createImage();

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                image = createImage();
            }
        });
    }

    public static Display getInstance() {
        if (instance == null) instance = new Display();
        return instance;
    }

    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) image.getGraphics();
    }

    @Override
    public void repaint() {
        panel.getGraphics().drawImage(image,0,0,null);

        Graphics2D g = getGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
        g.dispose();
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    @Override
    public void addKeyListener(KeyAdapter ka) {
        frame.addKeyListener(ka);
    }

    private Image createImage(){
        return panel.createImage(getWidth(),getHeight());
    }
}
