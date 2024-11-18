package week7.task4;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SalesReport {

    // Generate a full report
    public void generateReport(List<Sale> sales) {
        System.out.println("Full Sales Report:");
        sales.forEach(System.out::println);

        // Calculate total revenue
        double totalRevenue = sales.stream().mapToDouble(Sale::getAmount).sum();
        System.out.println("Total Revenue: " + totalRevenue);

        // Calculate average sale amount
        OptionalDouble averageSale = sales.stream().mapToDouble(Sale::getAmount).average();
        System.out.println("Average Sale Amount: " + (averageSale.isPresent() ? averageSale.getAsDouble() : 0.0));
    }

    // Generate a report filtered by product category
    public void generateReport(List<Sale> sales, String productCategory) {
        System.out.println("\nSales Report for Category: " + productCategory);
        List<Sale> filteredSales = sales.stream()
                .filter(sale -> sale.getProductCategory().equalsIgnoreCase(productCategory))
                .collect(Collectors.toList());

        filteredSales.forEach(System.out::println);

        // Calculate total revenue for this category
        double totalRevenue = filteredSales.stream().mapToDouble(Sale::getAmount).sum();
        System.out.println("Total Revenue for " + productCategory + ": " + totalRevenue);

        // Calculate average sale amount for this category
        OptionalDouble averageSale = filteredSales.stream().mapToDouble(Sale::getAmount).average();
        System.out.println("Average Sale Amount for " + productCategory + ": " + (averageSale.isPresent() ? averageSale.getAsDouble() : 0.0));
    }

    // Generate a report filtered by date range
    public void generateReport(List<Sale> sales, LocalDate startDate, LocalDate endDate) {
        System.out.println("\nSales Report from " + startDate + " to " + endDate);
        List<Sale> filteredSales = sales.stream()
                .filter(sale -> !sale.getDate().isBefore(startDate) && !sale.getDate().isAfter(endDate))
                .collect(Collectors.toList());

        filteredSales.forEach(System.out::println);

        // Calculate total revenue for this date range
        double totalRevenue = filteredSales.stream().mapToDouble(Sale::getAmount).sum();
        System.out.println("Total Revenue for the given period: " + totalRevenue);

        // Calculate average sale amount for this period
        OptionalDouble averageSale = filteredSales.stream().mapToDouble(Sale::getAmount).average();
        System.out.println("Average Sale Amount for the given period: " + (averageSale.isPresent() ? averageSale.getAsDouble() : 0.0));
    }
}
