import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;
import static java.util.Collections.shuffle;

public class Bouncers {
    private final LinkedList<Bouncable> bouncers = new LinkedList<>();
    boolean running;

    final int MAX_SIZE = 50;
    final int MAX_SPEED = 5;
    final int FPS = 25;

    public Bouncers() {
        running = true;
    }

    private void createSquaresBatch(BouncerFactory factory, int amount) {
        Display display = Display.getInstance();
        Random r = new Random();

        for (int i = 0; i < amount; ++i) {
            bouncers.add(factory.createSquare(
                    r.nextInt(display.getWidth() - MAX_SIZE),
                    r.nextInt(display.getHeight() - MAX_SIZE),
                    r.nextInt(MAX_SIZE),
                    r.nextInt(MAX_SPEED) * (r.nextBoolean() ? 1 : -1),
                    r.nextInt(MAX_SPEED) * (r.nextBoolean() ? 1 : -1))
            );
        }
    }

    private void createCircleBatch(BouncerFactory factory, int amount) {
        Display display = Display.getInstance();
        Random r = new Random();

        for (int i = 0; i < amount; ++i) {
            bouncers.add(factory.createCircle(
                    r.nextInt(display.getWidth() - MAX_SIZE),
                    r.nextInt(display.getHeight() - MAX_SIZE),
                    r.nextInt(MAX_SIZE),
                    r.nextInt(MAX_SPEED) * (r.nextBoolean() ? 1 : -1),
                    r.nextInt(MAX_SPEED) * (r.nextBoolean() ? 1 : -1))
            );
        }
    }

    public void run() {

        Display display = Display.getInstance();

        Display.getInstance().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_E -> bouncers.clear();
                    case KeyEvent.VK_B -> {
                        createSquaresBatch(NotFilledFactory.getInstance(), 5);
                        createCircleBatch(NotFilledFactory.getInstance(), 5);
                    }
                    case KeyEvent.VK_F -> {
                        createCircleBatch(FilledFactory.getInstance(), 5);
                        createSquaresBatch(FilledFactory.getInstance(), 5);
                    }
                    case KeyEvent.VK_Q -> System.exit(0);
                }
            }
        });


        long lastTime, currentTime;
        lastTime = System.currentTimeMillis() - 40;
        while (running) {
            currentTime = System.currentTimeMillis();
            try {
                Thread.sleep(Math.max((1000 / FPS) - (currentTime - lastTime), 0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lastTime = System.currentTimeMillis();


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

        }
    }

    public static void main(String... args) {
        new Bouncers().run();
    }
}