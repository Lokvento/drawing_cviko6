package pro1.swingComponents;

import pro1.drawingModel.*;
import pro1.drawingModel.Rectangle;
// import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private DisplayPanel displayPanel;
    // private int x;
    // private int y;
    // private String color = "#000000";
    private List<Point> circles = new ArrayList<>();
    private int radius = 10;
    private boolean hide = false;
    // public void setColor(String color) {
    // this.color = color;
    // }

    public MainFrame() {
        this.setTitle("PRO1 Drawing");
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.displayPanel = new DisplayPanel();
        this.add(this.displayPanel, BorderLayout.CENTER);

        JPanel leftPanel = new OptionsPanel(this);
        this.add(leftPanel, BorderLayout.WEST);

        this.displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // MainFrame.this.x = e.getX();
                // MainFrame.this.y = e.getY();
                // MainFrame.this.showExample();
                circles.add(new Point(e.getX(), e.getY()));
                updateCanvas();
            }
        });
    }

    public void setRadius(int radius) {
        this.radius = radius;
        updateCanvas();

    }

    public void setHide(boolean hide) {
        this.hide = hide;
        updateCanvas();
    }

    public void resetCanvas() {
        this.circles.clear();
        updateCanvas();
    }

    private void updateCanvas() {
        List<Drawable> elements = new ArrayList<>();
        if (this.circles.size() >= 2 && !this.hide) {
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            for (Point p : this.circles) {
                if (p.x < minX)
                    minX = p.x;
                if (p.y < minY)
                    minY = p.y;
                if (p.x > maxX)
                    maxX = p.x;
                if (p.y > maxY)
                    maxY = p.y;
            }
            int rectX = minX;
            int rectY = minY;
            int rectWidth = maxX - minX;
            int rectHeight = maxY - minY;
            elements.add(new Rectangle(rectX, rectY, rectWidth, rectHeight, "#FF0000"));
        }
        int diameter = 2 * this.radius;
        for (Point p : this.circles) {
            int topLeftX = p.x - this.radius;
            int topLeftY = p.y - this.radius;
            elements.add(new Ellipse(topLeftX, topLeftY, diameter, diameter, "#000000"));
        }
        Drawable[] elementsArray = elements.toArray(new Drawable[0]);
        Group main = new Group(elementsArray, 0, 0, 0, 1, 1);
        this.displayPanel.setDrawable(main);
    }
    // public void showExample(){
    // MainFrame.this.displayPanel.setDrawable(this.example());
    // }

    // private Drawable example() {
    // var d1 = new Ellipse(0, 0, 150, 250, this.color);
    // var d2 = new Text(0, 0, this.color);
    // var d3 = new Line(0, 50,170,170,3, this.color);
    // return new Group(new Drawable[]{d1, d2, d3}, this.x, this.y, 40, 1, 1);
    // }
}