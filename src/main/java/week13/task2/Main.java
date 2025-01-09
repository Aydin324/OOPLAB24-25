package week13.task2;

public class Main {
    public static void main(String[] args) {


        //create payment objects
        Payment ccPayment = PaymentFactoryClass.createPayment("creditCard");
        Payment ppPayment = PaymentFactoryClass.createPayment("PayPal");

        //call processPayment()
        ccPayment.processPayment();
        ppPayment.processPayment();
    }
}
