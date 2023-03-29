import java.awt.*;

public class FilledRender implements Renderer {
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setPaint(b.getColor());
        g.fill(b.getShape());
        g.draw(b.getShape());
    }
}
