package inf101v22.mockexam.traffic.control;

import java.awt.event.ActionEvent;

import inf101v22.mockexam.observable.Observable;

public interface ITrafficGuiController {

    /** Returns an observable indicating whether the controller is paused or not. */
    Observable<Boolean> isPaused();

    /** Called when pause button is pressed. */
    void pausePressed(ActionEvent e);

    /** Called when start button is pressed. */
    void startPressed(ActionEvent e);
    
}
