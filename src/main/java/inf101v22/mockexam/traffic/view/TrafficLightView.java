package inf101v22.mockexam.traffic.view;

import inf101v22.mockexam.traffic.model.TrafficLightViewable;

import javax.swing.*;
import java.awt.*;

public class TrafficLightView extends JComponent {

    LampView redLamp;
    LampView yellowLamp;
    LampView greenLamp;

    public TrafficLightView(TrafficLightViewable model) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        redLamp = new LampView(model.redIsOn(), Color.RED);
        yellowLamp = new LampView(model.yellowIsOn(), Color.YELLOW);
        greenLamp = new LampView(model.greenIsOn(), Color.GREEN);

        add(redLamp);
        add(yellowLamp);
        add(greenLamp);
    }

}
