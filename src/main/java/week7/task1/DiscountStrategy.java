package week7.task1;

@FunctionalInterface
public interface DiscountStrategy {
    double applyDiscount(double price, int quantity);
}
