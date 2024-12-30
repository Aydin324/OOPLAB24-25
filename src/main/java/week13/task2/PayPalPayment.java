package week13.task2;

public class PayPalPayment implements Payment {
    @Override
    public void processPayment(){
        System.out.println("PayPal payment processed.");
    }
}
