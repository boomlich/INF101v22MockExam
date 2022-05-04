package inf101v22.mockexam.traffic.model;

import inf101v22.mockexam.observable.Observable;

public interface TrafficLightViewable {

    /**
     * Gets an observable for the state of the red lamp. To access the actual boolean
     * value signifying whether the red light is currently on, make a call to
     * {@link Observable#getValue getValue} on the returned object.
     * 
     * @return an observable variable indicating the state of the red lamp
     */
    Observable<Boolean> redIsOn();

    /**
     * Gets an observable for the state of the yellow lamp. To access the actual boolean
     * value signifying whether the yellow light is currently on, make a call to
     * {@link Observable#getValue getValue} on the returned object.
     * 
     * @return an observable variable indicating the state of the yellow lamp
     */
    Observable<Boolean> yellowIsOn();

    /**
     * Gets an observable for the state of the green lamp. To access the actual boolean
     * value signifying whether the green light is currently on, make a call to
     * {@link Observable#getValue getValue} on the returned object.
     * 
     * @return an observable variable indicating the state of the green lamp
     */
    Observable<Boolean> greenIsOn();

}
