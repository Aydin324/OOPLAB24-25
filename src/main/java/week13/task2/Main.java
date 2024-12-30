package week13.task2;

public class Main {
    public static void main(String[] args) {
        //instantiate factories
        CreditCardPaymentFactory ccFactory = new CreditCardPaymentFactory();
        PayPalPaymentFactory ppFactory = new PayPalPaymentFactory();

        //create payment objects
        Payment ccPayment = ccFactory.createPayment();
        Payment ppPayment = ppFactory.createPayment();

        //call processPayment()
        ccPayment.processPayment();
        ppPayment.processPayment();
    }
}
