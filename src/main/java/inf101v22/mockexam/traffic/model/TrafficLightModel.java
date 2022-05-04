package inf101v22.mockexam.traffic.model;

import inf101v22.mockexam.observable.ControlledObservable;
import inf101v22.mockexam.observable.Observable;

public class TrafficLightModel implements TrafficLightControllable{

    ControlledObservable<Boolean> redLightOn;
    ControlledObservable<Boolean> yellowLightOn;
    ControlledObservable<Boolean> greenLightOn;
    LightState lightState;
    int lightStateTimer;


    public TrafficLightModel() {
        redLightOn = new ControlledObservable<>(true);
        yellowLightOn = new ControlledObservable<>(false);
        greenLightOn = new ControlledObservable<>(false);
        lightState = LightState.STOP;
        lightStateTimer = 2000;
    }

    @Override
    public void goToNextState() {
        disableAllLights();
        if (lightState == LightState.STOP) {
            modeReady();
        } else if (lightState == LightState.READY) {
            modeGo();
        } else if (lightState == LightState.GO) {
            modeSlowDown();
        } else if (lightState == LightState.SLOW_DOWN) {
            modeStop();
        }
    }

    private void disableAllLights() {
        redLightOn.setValue(false);
        yellowLightOn.setValue(false);
        greenLightOn.setValue(false);
    }

    private void modeStop() {
        redLightOn.setValue(true);
        lightState = LightState.STOP;
        lightStateTimer = 2000;
    }

    private void modeReady() {
        redLightOn.setValue(true);
        yellowLightOn.setValue(true);
        lightState = LightState.READY;
        lightStateTimer = 500;
    }

    private void modeGo() {
        greenLightOn.setValue(true);
        lightState = LightState.GO;
        lightStateTimer = 2000;
    }

    private void modeSlowDown() {
        yellowLightOn.setValue(true);
        lightState = LightState.SLOW_DOWN;
        lightStateTimer = 1000;
    }

    @Override
    public int minMillisInCurrentState() {
        return lightStateTimer;
    }

    @Override
    public Observable<Boolean> redIsOn() {
        return redLightOn;
    }

    @Override
    public Observable<Boolean> yellowIsOn() {
        return yellowLightOn;
    }

    @Override
    public Observable<Boolean> greenIsOn() {
        return greenLightOn;
    }
}
