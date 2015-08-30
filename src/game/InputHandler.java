package game;

import display.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    private Player player;

    public InputHandler(Display display, Player player){
        display.getCanvas().addKeyListener(this);
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            this.player.movingUp = true;
           // this.player.isStanding = false;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            this.player.movingDown = true;
           // this.player.isStanding = false;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            this.player.movingRight = true;
            this.player.isStanding = false;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            this.player.movingLeft = true;
          //  this.player.isStanding = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            this.player.movingUp = false;
          //  this.player.isStanding = true;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            this.player.movingDown = false;
           // this.player.isStanding = true;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            this.player.movingRight = false;
            this.player.isStanding = true;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            this.player.movingLeft = false;
           // this.player.isStanding = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
