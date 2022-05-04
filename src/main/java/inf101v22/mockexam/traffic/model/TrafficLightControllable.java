package inf101v22.mockexam.traffic.model;

public interface TrafficLightControllable extends TrafficLightViewable {

    /**
     * Goes to the next state of the traffic light. The method will cycle through
     * the light states in the following order: red light is on, red and yellow
     * light is on, green light is on, and yellow light is on.
     */
    void goToNextState();

    /**
     * Gets the minimum number of milliseconds the light ought to stay in the
     * current state before the next call to goToNextState. 
     * 
     * @return number of milliseconds
     */
    int minMillisInCurrentState();
}
