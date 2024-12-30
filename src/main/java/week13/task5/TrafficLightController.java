package week13.task5;

public class TrafficLightController {
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext();

        context.transitionToYellow();
        context.transitionToGreen();
        context.transitionToGreen();
        context.transitionToRed();
    }
}
