public class TrafficLights {

    public enum TrafficState {
        NS_GREEN,
        NS_YELLOW,
        EW_GREEN,
        EW_YELLOW
    }

    private TrafficState currentState;

    public TrafficLights() {
        currentState = TrafficState.NS_GREEN;
    }

    public TrafficState getState() {
        return currentState;
    }

    public void nextState() {
        switch (currentState) {
            case NS_GREEN:
                currentState = TrafficState.NS_YELLOW;
                break;

            case NS_YELLOW:
                currentState = TrafficState.EW_GREEN;
                break;

            case EW_GREEN:
                currentState = TrafficState.EW_YELLOW;
                break;

            case EW_YELLOW:
                currentState = TrafficState.NS_GREEN;
                break;
        }
    }

    public boolean isNorthSouthGreen() {
        return currentState == TrafficState.NS_GREEN;
    }

    public boolean isEastWestGreen() {
        return currentState == TrafficState.EW_GREEN;
    }

    public boolean isNorthSouthYellow() {
        return currentState == TrafficState.NS_YELLOW;
    }

    public boolean isEastWestYellow() {
        return currentState == TrafficState.EW_YELLOW;
    }
}