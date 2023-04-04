package display.renderer;

import bounceable.Bounceable;

import java.awt.Graphics2D;

public class FilledRender implements Renderer {

    static private FilledRender instance;

    private FilledRender(){};

    public static Renderer getInstance() {
        if (instance == null){
            instance = new FilledRender();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bounceable b) {
        g.setPaint(b.getColor());
        g.fill(b.getShape());
        g.draw(b.getShape());
    }
}
