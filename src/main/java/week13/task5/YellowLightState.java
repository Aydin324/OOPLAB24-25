package week13.task5;

public class YellowLightState implements TrafficLightState{
    @Override
    public void transitionToRed(TrafficLightContext context){
        System.out.println("Transitioning to red");
        context.setState(new RedLightState());
    }
    @Override
    public void transitionToYellow(TrafficLightContext context){
        System.out.println("Light is already yellow");
    }
    @Override
    public void transitionToGreen(TrafficLightContext context){
        System.out.println("Transitioning to green");
        context.setState(new GreenLightState());
    }
}
