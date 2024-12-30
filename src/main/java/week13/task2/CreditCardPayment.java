package week13.task2;

public class CreditCardPayment implements Payment{
    @Override
    public void processPayment(){
        System.out.println("Credit card payment processed.");
    }
}
