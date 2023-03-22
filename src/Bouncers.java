import javax.swing.*;
import java.util.LinkedList;

public class Bouncers {
    private LinkedList<Bouncable> bouncers;

    public Bouncers() {
        /* … */
    }
    public void run() {
        int fps = 25;
        long lastTime, currentTime;
        lastTime = System.currentTimeMillis() - 40;
        while (true) {
            currentTime = System.currentTimeMillis();
            try {
                Thread.sleep(Math.max((1000 / fps) - (currentTime - lastTime), 0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lastTime = System.currentTimeMillis();

            // TODO : Whatever you want
            /*
            JFrame frame = new JFrame();
            frame.setSize(1000, 1000);
            frame.setVisible(true);
            */
        }
    }
    public static void main(String ... args) {
        new Bouncers().run();
    }
}