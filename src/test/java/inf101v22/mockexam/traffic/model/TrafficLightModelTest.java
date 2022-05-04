package inf101v22.mockexam.traffic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inf101v22.mockexam.observable.Observable;

public class TrafficLightModelTest {

    TrafficLightControllable trafficLight;
    private Observable<Boolean> r;
    private Observable<Boolean> y;
    private Observable<Boolean> g;

    @BeforeEach
    void init() {
         this.trafficLight = new TrafficLightModel();
        this.r = this.trafficLight.redIsOn();
        this.y = this.trafficLight.yellowIsOn();
        this.g = this.trafficLight.greenIsOn();
    }

    @Test
    void minReqsToStartPartB() {
        // In order to start on part b, you need to pass these tests. Basically, we're
        // testing that we don't get null values, and the model does not throw any
        // exceptions when being manipulated.
        assertNotEquals(null, trafficLight, "If you fail this test," +
                "try to uncomment line 23 (the first line in the init() method)");
        assertNotEquals(null, r, "redIsOn() returned null");
        assertNotEquals(null, y, "yellowIsOn() returned null");
        assertNotEquals(null, g, "greenIsOn() returned null");
        assertNotEquals(null, r.getValue(), "redIsOn().getValue() returned null");
        assertNotEquals(null, y.getValue(), "yellowIsOn().getValue() returned null");
        assertNotEquals(null, g.getValue(), "greenIsOn().getValue() returned null");

        assertTrue(r instanceof Observable, "redIsOn() did not return an observable.");
        assertTrue(y instanceof Observable, "yellowIsOn() did not return an observable.");
        assertTrue(g instanceof Observable, "greenIsOn() did not return an observable.");
        assertTrue(r.getValue() instanceof Boolean, "redIsOn().getValue() did not return a Boolean");
        assertTrue(y.getValue() instanceof Boolean, "yellowIsOn().getValue() did not return a Boolean");
        assertTrue(g.getValue() instanceof Boolean, "greenIsOn().getValue() did not return a Boolean");

        // Test that methods can be called repeatedly without throwing Exception
        for (int i = 0; i < 100; i++) {
            try {
                trafficLight.minMillisInCurrentState();
                trafficLight.goToNextState();
            } catch (Exception e) {
                fail(i + " Method threw an exception: " + e.getMessage());
            }
        }
    }

    @Test
    void testGoToNextState() {
        // In this test, we check that the model cycles through the correct states when
        // goToNextState is called.

        // Check that light initially is red, and the other lights are off
        assertTrue(r.getValue(), "Expected red state, but R was false.");
        assertFalse(y.getValue(), "Expected red state, but Y was true.");
        assertFalse(g.getValue(), "Expected red state, but G was true.");
        this.trafficLight.goToNextState();

        // The second state is the red+yellow state.
        assertTrue(r.getValue(), "Expected r+y state, but R was false.");
        assertTrue(y.getValue(), "Expected r+y state, but Y was false.");
//        System.out.println(g.getValue());
        assertFalse(g.getValue(), "Expected r+y state, but G was true.");
        this.trafficLight.goToNextState();

        // The third state is the green state.
        assertFalse(y.getValue(), "Expected green state, but R was true.");
        assertFalse(r.getValue(), "Expected green state, but Y was true.");
        assertTrue(g.getValue(), "Expected green state, but G was false.");
        this.trafficLight.goToNextState();

        // Fourth state is the yellow state
        assertFalse(r.getValue(), "Expected yellow state, but R was true.");
        assertTrue(y.getValue(), "Expected yellow state, but Y was false.");
        assertFalse(g.getValue(), "Expected yellow state, but G was true.");
        this.trafficLight.goToNextState();

        // Back to red lights
        assertTrue(r.getValue(), "Expected red state, but R was false.");
        assertFalse(y.getValue(), "Expected red state, but Y was true.");
        assertFalse(g.getValue(), "Expected red state, but G was true.");
    }

    @Test
    void testGoToNextStateAndMillis() {
        // In this test, we check that the model reports the correct number of
        // milliseconds that is minimum for each state of the lights.
        // Red state:    2000 ms
        // R+Y state:     500 ms
        // Green state:  2000 ms
        // Yellow state: 1000 ms
        // For convenience, we also check that the expected light state is present.

        // Check that light initially is red, and the other lights are off
        assertTrue(r.getValue());
        assertFalse(y.getValue());
        assertFalse(g.getValue());
        assertEquals(2000, trafficLight.minMillisInCurrentState());
        this.trafficLight.goToNextState();

        // The second state is the red+yellow state.
        assertTrue(r.getValue());
        assertTrue(y.getValue());
        assertFalse(g.getValue());
        assertEquals(500, trafficLight.minMillisInCurrentState());
        this.trafficLight.goToNextState();

        // The third state is the green state.
        assertFalse(r.getValue());
        assertFalse(y.getValue());
        assertTrue(g.getValue());
        assertEquals(2000, trafficLight.minMillisInCurrentState());
        this.trafficLight.goToNextState();

        // Fourth state is the yellow state
        assertFalse(r.getValue());
        assertTrue(y.getValue());
        assertFalse(g.getValue());
        assertEquals(1000, trafficLight.minMillisInCurrentState());
        this.trafficLight.goToNextState();
    }

    @Test
    void repeatedCycles() {
        for (int i = 0; i < 100; i++) {
            testGoToNextStateAndMillis();
        }
    }

}
