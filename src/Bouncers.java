import java.util.LinkedList;
import java.util.Random;
import static java.util.Collections.shuffle;

public class Bouncers {
    private final LinkedList<Bouncable> bouncers = new LinkedList<>();
    boolean running;

    final int maxSize = 50;
    final int maxSpeed = 5;

    public Bouncers() {
        running = true;
        createCircleBatch(new NotFilledFactory(), 5);
        createCircleBatch(new FilledFactory(), 7);
        createSquaresBatch(new FilledFactory(), 3);
        createSquaresBatch(new NotFilledFactory(), 4);
    }

    private void createSquaresBatch(BouncerFactory factory, int amount) {
        Display display = Display.getInstance();
        Random r = new Random();

        for (int i = 0; i < amount; ++i) {
            bouncers.add(factory.createSquare(
                    r.nextInt(display.getWidth() - maxSize),
                    r.nextInt(display.getHeight() - maxSize),
                    r.nextInt(maxSize),
                    r.nextInt(maxSpeed) * (r.nextBoolean() ? 1 : -1),
                    r.nextInt(maxSpeed) * (r.nextBoolean() ? 1 : -1))
            );
        }
    }

    private void createCircleBatch(BouncerFactory factory, int amount) {
        Display display = Display.getInstance();
        Random r = new Random();

        for (int i = 0; i < amount; ++i) {
            bouncers.add(factory.createCircle(
                    r.nextInt(display.getWidth() - maxSize),
                    r.nextInt(display.getHeight() - maxSize),
                    r.nextInt(maxSize),
                    r.nextInt(maxSpeed) * (r.nextBoolean() ? 1 : -1),
                    r.nextInt(maxSpeed) * (r.nextBoolean() ? 1 : -1))
            );
        }
    }

    public void run() {

        Display display = Display.getInstance();

        int fps = 25;
        long lastTime, currentTime;
        lastTime = System.currentTimeMillis() - 40;
        while (running) {
            currentTime = System.currentTimeMillis();
            try {
                Thread.sleep(Math.max((1000 / fps) - (currentTime - lastTime), 0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lastTime = System.currentTimeMillis();

            //Press 'e' -> bouncers.clear();

            for (Bouncable bounce : bouncers) {
                bounce.check(display.getWidth(), display.getHeight());
            }
            for (Bouncable bounce : bouncers) {
                bounce.move();
            }
            for (Bouncable bounce : bouncers) {
                bounce.draw();
            }
            display.repaint();

            //Press 'q' -> running = false;
        }
    }

    public void checkAllBouncables(){
        Display display = Display.getInstance();
        for (Bouncable bounce : bouncers) {
            bounce.check(display.getWidth(), display.getHeight());
        }
    }

    public static void main(String... args) {
        new Bouncers().run();
    }
}