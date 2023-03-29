import java.awt.*;

public class FilledRender implements Renderer {

    static FilledRender instance;

    private FilledRender(){};

    public static Renderer getInstance() {
        if (instance == null){
            instance = new FilledRender();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setPaint(b.getColor());
        g.fill(b.getShape());
        g.draw(b.getShape());
    }
}
