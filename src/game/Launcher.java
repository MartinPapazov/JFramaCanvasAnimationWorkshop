package game;

public class Launcher {

    public static void main(String[] args) {
        Engine engine = new Engine("Java app!",700, 350);
        engine.start();
    }
}
