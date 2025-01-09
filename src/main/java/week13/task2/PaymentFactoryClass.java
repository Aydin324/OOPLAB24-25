package week13.task2;

public class PaymentFactoryClass {
    public static Payment createPayment(String type){
        switch(type){
            case "creditCard":
                return new CreditCardPayment();
            case "PayPal":
                return new PayPalPayment();
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}
