package week13.task5;

public class GreenLightState implements TrafficLightState{
    @Override
    public void transitionToRed(TrafficLightContext context){
        System.out.println("Cannot transition directly to red");
    }
    @Override
    public void transitionToYellow(TrafficLightContext context){
        System.out.println("Transitioning to yellow");
        context.setState(new YellowLightState());
    }
    @Override
    public void transitionToGreen(TrafficLightContext context){
        System.out.println("Light is already green");
    }
}
