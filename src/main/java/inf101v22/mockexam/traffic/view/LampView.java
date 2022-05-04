package inf101v22.mockexam.traffic.view;

import inf101v22.mockexam.observable.Observable;

import javax.swing.*;
import java.awt.*;

public class LampView extends JComponent {

    Observable<Boolean> lightStatus;
    Color lightColor;

    public LampView(Observable<Boolean> lightStatus, Color lightColor) {
        this.lightStatus = lightStatus;
        this.lightColor = lightColor;

        lightStatus.addObserver(this::repaint);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getColor());

        g.fillOval(0, 0, getWidth(), getHeight());
    }

    private Color getColor() {
        if (!lightStatus.getValue()) {
            return lightColor.darker().darker().darker().darker();
        }
        return lightColor;
    }

    @Override
    public Dimension preferredSize() {
        return new Dimension(50, 50);
    }
}
