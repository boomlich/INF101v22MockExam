package inf101v22.mockexam.traffic;

import javax.swing.JFrame;

import inf101v22.mockexam.traffic.control.TrafficLightController;
import inf101v22.mockexam.traffic.model.TrafficLightModel;
import inf101v22.mockexam.traffic.view.Root;

public class App {
    
    public static void main(String[] args) {
        new App();
    }
    
    public App() {
        JFrame frame = new JFrame("INF101 Traffic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TrafficLightModel model = new TrafficLightModel();
        TrafficLightController controller = new TrafficLightController(model);
        Root view = new Root(controller, model);
        frame.setContentPane(view);

        frame.pack();
        frame.setVisible(true);
    }
}
