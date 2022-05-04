package inf101v22.mockexam.traffic.control;

import inf101v22.mockexam.observable.ControlledObservable;
import inf101v22.mockexam.observable.Observable;
import inf101v22.mockexam.traffic.model.TrafficLightControllable;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TrafficLightController implements ITrafficGuiController{

    TrafficLightControllable model;
    Timer timer;
    ControlledObservable<Boolean> isPaused;

    public TrafficLightController(TrafficLightControllable model) {
        this.model = model;
        isPaused = new ControlledObservable<>(true);
        timer = new Timer(model.minMillisInCurrentState(), this::timerFired);
    }

    private void timerFired(ActionEvent e) {
        model.goToNextState();
        timer.setInitialDelay(model.minMillisInCurrentState());
        timer.restart();
    }

    @Override
    public Observable<Boolean> isPaused() {
        return isPaused;
    }

    @Override
    public void pausePressed(ActionEvent e) {
        isPaused.setValue(true);
        timer.stop();
    }

    @Override
    public void startPressed(ActionEvent e) {
        if (isPaused.getValue()) {
            timer.restart();
        }
        isPaused.setValue(false);
    }
}
