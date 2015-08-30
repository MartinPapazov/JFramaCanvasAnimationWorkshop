package graphics;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 95;
    private static final int height = 130;
    private static BufferedImage PlayerOneImage;
    private static SpriteSheetAnimation playerTwoStandingAnimation;
    private static SpriteSheetAnimation playerTwoMovingRightAnimation;

    public static BufferedImage getPlayerOne(){
        return PlayerOneImage;
    }

    public static BufferedImage getPlayerTwoStandingAnimation(){
        return playerTwoStandingAnimation.animationCrop();
    }

    public static BufferedImage getPlayerTwoMovingRightAnimation(){
        return playerTwoMovingRightAnimation.animationCrop();
    }

    public static void initialization() {
        BufferedImage spriteSheet = ImageLoader.loadImage("/images/player.png");
        PlayerOneImage = new SpriteSheet(spriteSheet).crop(0, 0, width, height);
        playerTwoStandingAnimation = new SpriteSheetAnimation(spriteSheet, width * 4, height * 2, width, height, 3, 50);
        playerTwoMovingRightAnimation = new SpriteSheetAnimation(spriteSheet, 0, 0, width, height, 7, 20);
    }
}
