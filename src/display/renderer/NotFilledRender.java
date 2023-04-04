package display.renderer;

import bounceable.Bounceable;

import java.awt.*;

public class NotFilledRender implements Renderer {
    static private final BasicStroke STROKE = new BasicStroke(5);

    static private NotFilledRender instance;

    private NotFilledRender(){};

    public static Renderer getInstance() {
        if (instance == null){
            instance = new NotFilledRender();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bounceable b) {
        g.setStroke(STROKE);
        g.setPaint(b.getColor());
        g.draw(b.getShape());
    }
}
