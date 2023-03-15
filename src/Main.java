import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Display.getInstance().repaint();
            sleep(50);
        }

    }
}