import java.awt.*;
import java.util.LinkedList;

public class Bouncers {
    private LinkedList<Bouncable> bouncers = new LinkedList<>();

    public Bouncers() {

        bouncers.add(new FilledSquare(4,6,1,1,40, Color.BLUE));
        bouncers.add(new FilledCircle(87,63,1,1,25, Color.RED));
        bouncers.add(new NotFilledSquare(443,6,1,1,30, Color.GRAY));
        bouncers.add(new NotFilledCircle(43,64,1,1,10, Color.GREEN));

    }
    public void run() {

        Display display = Display.getInstance();

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


            for (Bouncable bounce : bouncers){
                bounce.check(display.getWidth(), display.getHeight());
            }
            for (Bouncable bounce : bouncers){
                bounce.move();
            }
            for (Bouncable bounce : bouncers){
                bounce.draw();
            }
            display.repaint();
        }
    }
    public static void main(String ... args) {
        new Bouncers().run();
    }
}