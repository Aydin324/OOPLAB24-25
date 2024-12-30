package week13.task5;

public class TrafficLightContext {
    private TrafficLightState currentState;

    public TrafficLightContext() {
        this.currentState = new RedLightState();
        System.out.println("Light is red");
    }

    public void setState(TrafficLightState newState) {
        this.currentState = newState;
    }

    public void transitionToRed(){
        currentState.transitionToRed(this);
    }
    public void transitionToGreen(){
        currentState.transitionToGreen(this);
    }
    public void transitionToYellow(){
        currentState.transitionToYellow(this);
    }
}
