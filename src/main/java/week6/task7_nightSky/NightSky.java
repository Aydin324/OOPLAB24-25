package week6.task7_nightSky;

import java.util.Random;

public class NightSky {
    private double density;
    private int width, height;

    public NightSky(double density){
        this.density = density;
        this.width = 20;
        this.height = 10;
    }
    public NightSky(int height, int width){
        this.density = 0.1;
        this.width = width;
        this.height = height;
    }
    public NightSky(double density, int width, int height){
        this.density = density;
        this.width = width;
        this.height = height;
    }

    public void printLine(){
        Random rand = new Random();
        int probability = (int)(this.density*100);
        int generatedNumber;

        for(int i=0; i<this.width; i++){
            generatedNumber = rand.nextInt(100)+1;
            if(generatedNumber <= probability)
                System.out.print("*");

            else
                System.out.print(" ");
        }



    }
}
