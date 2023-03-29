import java.awt.*;

public class NotFilledRender implements Renderer {
    static final BasicStroke STROKE = new BasicStroke(5);
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setStroke(STROKE);
        g.setPaint(b.getColor());
        g.draw(b.getShape());
    }
}
