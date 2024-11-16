package week7.task1;

import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        //implementing different discount strategies
        DiscountStrategy percentageDiscount = (double p, int q) -> p * 0.9;
        DiscountStrategy fixedDiscount = (double p, int q) -> p - 10;
        DiscountStrategy bulkDiscount = (double p, int q) -> q>2 ? p*0.7 : p;

        //sample products
        List<Product> products = asList(
                new Product("Laptop", 1000.00, 1),
                new Product("Smartphone", 500.00, 2),
                new Product("Headphones", 200.00, 3)
        );

        // Apply and test strategies
        System.out.println("Total with Percentage Discount: $" +
                totalDiscountedPrice(products, percentageDiscount));
        System.out.println("Total with Fixed Discount: $" +
                totalDiscountedPrice(products, fixedDiscount));
        System.out.println("Total with Bulk Discount: $" +
                totalDiscountedPrice(products, bulkDiscount));

    }

    public static double totalDiscountedPrice(List<Product> products, DiscountStrategy discountStrategy){
        double total = 0;
        for(Product product : products){
            total += (discountStrategy.applyDiscount(product.price(), product.quantity()) * product.quantity());
        }
        return total;
    }
}
