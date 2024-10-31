package week5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Car("Polo", 125000, 60));
        vehicles.add(new Truck("MAN TGX", 470000, 85));
        vehicles.add(new Motorcycle("Aprilia RSV4"));

        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.service());
            vehicle.simulateYear();
            if(vehicle instanceof Car){
                Car car = (Car)vehicle;
                car.drive(5000);
            }
            else if(vehicle instanceof Truck){
                Truck truck = (Truck)vehicle;
                truck.haul(6000);
            }
            else {
                Motorcycle motorcycle = (Motorcycle)vehicle;
                motorcycle.race(300);
            }
            System.out.println(vehicle + "\n\n");
        }
    }
}
