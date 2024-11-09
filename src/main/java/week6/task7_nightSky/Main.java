package week6.task7_nightSky;

public class Main {
    public static void main(String[] args) {
        NightSky nightSky = new NightSky(0.12, 8, 6);
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint() + "\n\n");

        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
    }
}
