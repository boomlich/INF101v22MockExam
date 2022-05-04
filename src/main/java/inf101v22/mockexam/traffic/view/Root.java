package inf101v22.mockexam.traffic.view;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import inf101v22.mockexam.observable.Observable;
import inf101v22.mockexam.traffic.control.ITrafficGuiController;
import inf101v22.mockexam.traffic.model.TrafficLightViewable;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

public class Root extends JPanel {
    
    private JButton pauseButton;
    private JButton startButton;
    private JComponent demoView;
    private Observable<Boolean> isPaused;
    private TrafficLightViewable model;

    public Root(ITrafficGuiController controller, TrafficLightViewable model) {
        this.createButtons(controller);
        this.demoView = new TrafficLightView(model);
        this.initLayout();
        this.model = model;
    }

    private void createButtons(ITrafficGuiController controller) {
        this.pauseButton = new JButton("Pause");
        this.startButton = new JButton("Start");

        // Prevent crashing early in the task by disabling any 
        // use of the controller if it is null
        if (controller == null) {
            this.startButton.setEnabled(false);
            this.pauseButton.setEnabled(false);
            return;
        }

        this.isPaused = controller.isPaused();

        // When pause status changes, recalculate whether buttons are enabled or not
        this.isPaused.addObserver(this::updateButtonEnabled);
        this.updateButtonEnabled();

        // When a button is pressed, called the corresponding methods in the controller.
        this.pauseButton.addActionListener(controller::pausePressed);
        this.startButton.addActionListener(controller::startPressed);
    }

    private void initLayout() {
        // The left panel contains the buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(this.pauseButton);
        leftPanel.add(this.startButton);
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(Box.createRigidArea(new Dimension(110,0)));
        pauseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // The center panel contains the traffic light view
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(5, 5));
        centerPanel.add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.WEST);
        centerPanel.add(this.demoView, BorderLayout.CENTER);

        // Combine the left panel and the center panel
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(leftPanel);
        this.add(centerPanel);
    }

    private void updateButtonEnabled() {
        if (this.isPaused.getValue()) {
            this.startButton.setEnabled(true);
            this.pauseButton.setEnabled(false);
        } else {
            this.pauseButton.setEnabled(true);
            this.startButton.setEnabled(false);
        }
    }
}
