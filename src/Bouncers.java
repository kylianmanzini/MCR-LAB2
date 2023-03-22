import java.awt.*;
import java.util.LinkedList;

public class Bouncers {
    private LinkedList<Bouncable> bouncers = new LinkedList<>();

    public Bouncers() {

        bouncers.add(new FilledCircle(4,6,1,1,4, Color.BLUE));
        bouncers.add(new FilledCircle(87,63,1,1,4, Color.RED));
        bouncers.add(new FilledCircle(443,6,1,1,4, Color.GRAY));
        bouncers.add(new FilledCircle(43,64,1,1,4, Color.GREEN));

    }
    public void run() {
        Display display = Display.getInstance(bouncers);
        Renderer render = new Render();
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
                render.display(display.getGraphics(),bounce);
            }
        }
    }
    public static void main(String ... args) {
        new Bouncers().run();
    }
}