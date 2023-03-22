import java.awt.*;

public class Render implements Renderer {
    @Override
    public void display(Graphics2D g, Bouncable b) {
        b.draw();
        g.setPaint(b.getColor());
        g.fill(b.getShape());
    }
}
