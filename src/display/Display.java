package display;

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
    private final JPanel content;
    public final JFrame window;
    private Image img;


    private Display() {
        window = new JFrame();
        window.setSize(WINDOW_SIZE,WINDOW_SIZE);
        window.setMinimumSize(new Dimension(MIN_WIDTH,MIN_HEIGHT));
        window.setTitle("Bouncers");


        content = new JPanel();
        content.setSize(WINDOW_SIZE,WINDOW_SIZE);
        content.setBackground(Color.WHITE);
        window.setContentPane(content);



        // trigger when window is resized
        window.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                img = createImage();
            }
        });

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        img = createImage();
    }


    /**
     * Create or return the Display instance
     */
    public static Display getInstance() {
        if (instance == null) instance = new Display();
        return instance;
    }

    @Override
    public int getWidth() {
        return content.getWidth();
    }

    @Override
    public int getHeight() {
        return content.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) img.getGraphics();
    }

    @Override
    public void repaint() {
        content.getGraphics().drawImage(img,0,0,null);
        Graphics2D g = getGraphics();

        g.clearRect(0, 0, getWidth(), getHeight());
        g.dispose();
    }

    @Override
    public void setTitle(String title) {
        window.setTitle(title);
    }

    @Override
    public void addKeyListener(KeyAdapter ka) {
        window.addKeyListener(ka);
    }

    private Image createImage(){
        return content.createImage(getWidth(),getHeight());
    }
}
