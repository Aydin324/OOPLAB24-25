package midterm_preparation.task1_restaurant;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Dish pita = new Dish("38hfsjdn", "Burek", 14.60, CuisineType.ITALIAN, "meso");
        Dish cevapi = new Dish("kewkfjweoirjs", "Sarajevski cevapi", 15.00, CuisineType.MEXICAN, "meso");
        Dish sarma = new Dish("assfasjk", "Sarma", 8.50, CuisineType.CHINESE, "kupus");
        Drink kola = new Drink("sdfaf", "Coca Cola", 3.50, 250);

        Restaurant kodSukija = new Restaurant("kodSukija");

        kodSukija.addMenuItem(pita);
        kodSukija.addMenuItem(cevapi);
        kodSukija.addMenuItem(sarma);
        kodSukija.addMenuItem(kola);

        TableReservation<Dish> rezervacija1 = new TableReservation<>("1", new Date(), 1);
        rezervacija1.addItemToOrder(pita, 5);
        TableReservation<Drink> rezervacija2 = new TableReservation<>("2", new Date(), 2);
        rezervacija2.addItemToOrder(kola, 20);

        Customer Aydin = new Customer("1", "Aydin", "525150");
        Aydin.addReservation(rezervacija1);
        Aydin.addReservation(rezervacija2);

        kodSukija.addCustomer(Aydin);
        for(TableReservation<? extends MenuItem> i : Aydin.getReservations()){
            for(MenuItem j : i.getOrderedItems().keySet()){
                System.out.println(j.getName() + ": " + i.getOrderedItems().get(j));
            }
        }

        System.out.println("Total sales of kodSukija: " + kodSukija.calculateTotalSales());

    }
}
