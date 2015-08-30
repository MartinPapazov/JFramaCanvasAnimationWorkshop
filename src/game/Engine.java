package game;

import display.Display;
import graphics.Assets;
import graphics.ImageLoader;
import state.State;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Engine implements Runnable {

    //JFrame properties
    private int width;
    private int height;
    private String title;

    private Thread thread;
    private boolean isRunning;
    private Display display;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private InputHandler inputHandler;

    private State currentState;
    private Player superPlayer;
    private Rectangle enemny;


    public Engine(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.isRunning = false;
    }

    private void initialization(){
        this.display = new Display(this.title, this.width, this.height);
        Assets.initialization();
        this.superPlayer = new Player(100, 100, 200);
        //this.currentState = StateManager.getCurrentState();
        this.enemny = new Rectangle(500, 100, 20, 100);
        this.inputHandler = new InputHandler(this.display, this.superPlayer);
    }

    private void tick() {
        this.superPlayer.tick();
        if (this.superPlayer.intersects(this.enemny)){
            this.stop();
        }
    }

    private void render() {
        if (this.bufferStrategy == null){
            this.display.getCanvas().createBufferStrategy(2);
        }

        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
        this.graphics = this.bufferStrategy.getDrawGraphics();

        //Background drawing
        BufferedImage  backgroundImage = ImageLoader.loadImage("/images/background.jpg");
        this.graphics.drawImage(backgroundImage, 0, 0, this.width, this.height, null);

        //Start drawing
        this.superPlayer.render(this.graphics);
        this.graphics.setColor(Color.red);
        this.graphics.fillRect(this.enemny.x, this.enemny.y,this.enemny.width, this.enemny.height);
        //End drawing

        this.bufferStrategy.show();
        this.graphics.dispose();
    }

    @Override
        public void run() {
            this.initialization();

            int fps = 20;
            double timePerTick = 1_000_000_000.0 / fps;
            double deltaTime = 0;
            long now;
            long lastTimeTicked = System.nanoTime();

            while (isRunning){
                now = System.nanoTime();
                deltaTime += (now - lastTimeTicked) / timePerTick;
                lastTimeTicked = now;

                if (deltaTime >= 1) {
                    this.tick();
                    this.render();
                    deltaTime--;
                }
        }

        this.stop();
    }

    public synchronized void start() {
        if (isRunning){
            return;
        }

        this.isRunning = true;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public synchronized void stop() {
        if (!isRunning){
            return;
        }

        this.isRunning = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
