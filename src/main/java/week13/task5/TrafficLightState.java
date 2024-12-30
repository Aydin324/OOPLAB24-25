package week13.task5;

public interface TrafficLightState {
    public void transitionToRed(TrafficLightContext context);
    public void transitionToYellow(TrafficLightContext context);
    public void transitionToGreen(TrafficLightContext newContext);
}
