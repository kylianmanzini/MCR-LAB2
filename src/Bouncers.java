import java.awt.*;
import java.util.LinkedList;

public class Bouncers {
    private LinkedList<Bouncable> bouncers = new LinkedList<>();

    public Bouncers() {

        BouncerFactory ff = new FilledFactory();
        BouncerFactory nff = new NotFilledFactory();

        bouncers.add(ff.createCircle(4, 6, 40, 64, 40));
        bouncers.add(ff.createSquare(87, 63, 50, 12, 25));
        bouncers.add(nff.createCircle(443, 6, 12, 32, 30));
        bouncers.add(nff.createSquare(43, 64, 70, 5, 10));

    }

    private void createSquaresBatch(BouncerFactory factory, int amount) {
        for (int i = 0; i < amount; ++i) {
            bouncers.add(factory.createSquare(4, 5, 1, 1, 1));
        }
    }

    private void createCircleBatch(BouncerFactory factory, int amount) {
        for (int i = 0; i < amount; ++i) {
            bouncers.add(factory.createCircle(4, 5, 1, 1, 1));
        }
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
            for (Bouncable bounce : bouncers) {
                bounce.draw();
            }
            display.repaint();
        }
    }

    public static void main(String... args) {
        new Bouncers().run();
    }
}