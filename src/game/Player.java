package game;

import graphics.Assets;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Rectangle {
    public int x;
    public int y;
    public int health;
    private int velocity;

    public boolean isStanding;
    public boolean movingUp;
    public boolean movingDown;
    public boolean movingLeft;
    public boolean movingRight;

    private BufferedImage playerImage;
    private Rectangle boundingBox;

    public Player(int x, int y, int health) {
        this.x = x;
        this.y = y;
        this.health = health;

        this.velocity = 7;
        this.isStanding = true;
        this.movingDown = false;
        this.movingLeft = false;
        this.movingUp = false;
        this.movingRight = false;

        this.boundingBox = new Rectangle(this.x, this.y, 95, 130);
        this.playerImage = Assets.getPlayerTwoStandingAnimation();
    }

    public boolean intersects(Rectangle r){
        return r.contains(this.boundingBox) ||
                this.boundingBox.contains(r);
    }

    public void tick() {
        this.boundingBox.x = this.x;
        this.boundingBox.y = this.y;
        if (this.isStanding) {
            this.playerImage = Assets.getPlayerTwoStandingAnimation();
        }

        if (this.movingUp){
            this.y -= this.velocity;
        }

        if (this.movingDown){
            this.y += this.velocity;
        }

        if (this.movingLeft){
            this.x -= this.velocity;
        }

        if (this.movingRight){
            this.x += this.velocity;
            this.playerImage = Assets.getPlayerTwoMovingRightAnimation();
        }
    }

    public void render(Graphics graphics){
        graphics.drawImage(this.playerImage, this.x, this.y, null);

    }

}
