package pro1.swingComponents;

// import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final MainFrame parent;
    // private JSlider rSlider;
    // private JSlider gSlider;
    // private JSlider bSlider;
    private JSlider radiusSlider;
    private JCheckBox hideCheckBox;
    private JButton resetBtn;

    public OptionsPanel(MainFrame parent) {
        this.parent = parent;
        this.setPreferredSize(new Dimension(200, 0));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(new JLabel("Poloměr kružnice"));
        this.radiusSlider = new JSlider(1, 100, 10);
        this.add(this.radiusSlider);
        this.radiusSlider.addChangeListener((e) -> {
            this.parent.setRadius(this.radiusSlider.getValue());

        });

        this.hideCheckBox = new JCheckBox("Skrýt obdelník");
        this.add(this.hideCheckBox);
        this.hideCheckBox.addActionListener((e) -> {
            this.parent.setHide(this.hideCheckBox.isSelected());

        });

        this.resetBtn = new JButton("Reset");
        this.add(this.resetBtn);
        this.resetBtn.addActionListener((e) -> {
            this.parent.resetCanvas();
        });
        // JButton newColorBtn = new JButton("Náhodná barva");
        // this.add(newColorBtn);
        // newColorBtn.addActionListener(
        // (e)-> {
        // this.parent.setColor(ColorUtils.randomColor());
        // this.parent.showExample();
        // }
        // );
        // this.rSlider = new JSlider(0,255,0);
        // this.gSlider = new JSlider(0,255,0);
        // this.bSlider = new JSlider(0,255,0);
        // this.add(this.rSlider);
        // this.add(this.gSlider);
        // this.add(this.bSlider);
        // this.rSlider.addChangeListener((e)->this.sliderChanged());
        // this.gSlider.addChangeListener((e)->this.sliderChanged());
        // this.bSlider.addChangeListener((e)->this.sliderChanged());
    }

    // private void sliderChanged(){
    // this.parent.setColor(ColorUtils.color(
    // this.rSlider.getValue(),
    // this.gSlider.getValue(),
    // this.bSlider.getValue()
    // ));
    // this.parent.showExample();
    // }
}
