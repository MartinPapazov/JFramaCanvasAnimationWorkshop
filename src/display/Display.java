package display;

import javax.swing.*;
import java.awt.*;

public class Display extends Canvas{
    private int width;
    private int height;
    private String title;

    private JFrame frame;
    private Canvas canvas;


    public Display(String title, int width, int height) {
        this.width = width;
        this.title = title;
        this.height = height;
        this.CreateFrame();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    private void CreateFrame(){
        this.frame = new JFrame(this.title);
        this.frame.setSize(this.width, this.height);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
        this.frame.setFocusable(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.canvas = new Canvas();
        this.canvas.setPreferredSize(new Dimension(this.width, this.height));
        this.canvas.setMinimumSize(new Dimension(this.width, this.height));
        this.canvas.setMaximumSize(new Dimension(this.width, this.height));

        this.frame.add(this.canvas);
        this.frame.pack();
    }

}
