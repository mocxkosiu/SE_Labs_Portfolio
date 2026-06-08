import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TrafficLightsTest {

    @Test
    void testInitialState() {

        TrafficLights tl = new TrafficLights();

        assertEquals(
                TrafficLights.TrafficState.NS_GREEN,
                tl.getState()
        );
    }

    @Test
    void testTransitionNSGreenToNSYellow() {

        TrafficLights tl = new TrafficLights();

        tl.nextState();

        assertEquals(
                TrafficLights.TrafficState.NS_YELLOW,
                tl.getState()
        );
    }

    @Test
    void testTransitionNSYellowToEWGreen() {

        TrafficLights tl = new TrafficLights();

        tl.nextState();
        tl.nextState();

        assertEquals(
                TrafficLights.TrafficState.EW_GREEN,
                tl.getState()
        );
    }

    @Test
    void testTransitionEWGreenToEWYellow() {

        TrafficLights tl = new TrafficLights();

        tl.nextState();
        tl.nextState();
        tl.nextState();

        assertEquals(
                TrafficLights.TrafficState.EW_YELLOW,
                tl.getState()
        );
    }

    @Test
    void testTransitionEWYellowToNSGreen() {

        TrafficLights tl = new TrafficLights();

        tl.nextState();
        tl.nextState();
        tl.nextState();
        tl.nextState();

        assertEquals(
                TrafficLights.TrafficState.NS_GREEN,
                tl.getState()
        );
    }

    @Test
    void testFullCycleReturnsToInitialState() {

        TrafficLights tl = new TrafficLights();

        TrafficLights.TrafficState initialState = tl.getState();

        for(int i = 0; i < 4; i++) {
            tl.nextState();
        }

        assertEquals(initialState, tl.getState());
    }

    @Test
    void testNeverBothDirectionsGreen() {

        TrafficLights tl = new TrafficLights();

        for(int i = 0; i < 20; i++) {

            boolean northSouthGreen = tl.isNorthSouthGreen();
            boolean eastWestGreen = tl.isEastWestGreen();

            assertFalse(
                    northSouthGreen && eastWestGreen
            );

            tl.nextState();
        }
    }

    @Test
    void testOnlyOneGreenDirectionAtATime() {

        TrafficLights tl = new TrafficLights();

        for(int i = 0; i < 20; i++) {

            if(tl.getState() == TrafficLights.TrafficState.NS_GREEN) {
                assertTrue(tl.isNorthSouthGreen());
                assertFalse(tl.isEastWestGreen());
            }

            if(tl.getState() == TrafficLights.TrafficState.EW_GREEN) {
                assertTrue(tl.isEastWestGreen());
                assertFalse(tl.isNorthSouthGreen());
            }

            tl.nextState();
        }
    }

    @Test
    void test100Transitions() {

        TrafficLights tl = new TrafficLights();

        for(int i = 0; i < 100; i++) {

            boolean northSouthGreen = tl.isNorthSouthGreen();
            boolean eastWestGreen = tl.isEastWestGreen();

            assertFalse(
                    northSouthGreen && eastWestGreen
            );

            tl.nextState();
        }
    }
}