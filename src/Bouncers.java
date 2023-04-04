/**
 *  MCR - Laboratoire 2 Bouncers
 *  Rui Manuel Mota Carneiro, Kylian Manzini
 */

import bounceable.Bounceable;
import display.Display;
import factory.BouncerFactory;
import factory.FilledFactory;
import factory.NotFilledFactory;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.*;

public class Bouncers {
    private final LinkedList<Bounceable> BOUNCERS = new LinkedList<>();
    private boolean running;

    private final Lock MUTEX = new ReentrantLock();

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
            BOUNCERS.add(factory.createSquare(
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
            BOUNCERS.add(factory.createCircle(
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
                    case KeyEvent.VK_E -> {
                        MUTEX.lock();
                        BOUNCERS.clear();
                        MUTEX.unlock();
                    }
                    case KeyEvent.VK_B -> {
                        MUTEX.lock();
                        createSquaresBatch(NotFilledFactory.getInstance(), 5);
                        createCircleBatch(NotFilledFactory.getInstance(), 5);
                        MUTEX.unlock();
                    }
                    case KeyEvent.VK_F -> {
                        MUTEX.lock();
                        createCircleBatch(FilledFactory.getInstance(), 5);
                        createSquaresBatch(FilledFactory.getInstance(), 5);
                        MUTEX.unlock();
                    }
                    case KeyEvent.VK_Q ->
                        running = false;

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


            MUTEX.lock();

            for (Bounceable bounce : BOUNCERS) {
                bounce.move(display.getWidth(), display.getHeight());
            }
            for (Bounceable bounce : BOUNCERS) {
                bounce.draw();
            }
            display.repaint();

            MUTEX.unlock();
        }
        System.exit(0);
    }

    public static void main(String... args) {
        new Bouncers().run();
    }
}