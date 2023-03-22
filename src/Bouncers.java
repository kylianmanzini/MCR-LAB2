import javax.swing.*;
import java.util.LinkedList;

public class Bouncers {
    private LinkedList<Bouncable> bouncers;

    public Bouncers() {
        /* … */
    }
    public void run() {
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
    public static void main(String ... args) {
        new Bouncers().run();
    }
}