package week7.task4;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sale> sales = List.of(
                new Sale("Electronics", 200.0, LocalDate.of(2023, 1, 15)),
                new Sale("Clothing", 50.0, LocalDate.of(2023, 2, 22)),
                new Sale("Electronics", 300.0, LocalDate.of(2023, 3, 10)),
                new Sale("Clothing", 75.0, LocalDate.of(2023, 3, 25)),
                new Sale("Books", 15.0, LocalDate.of(2023, 4, 5)),
                new Sale("Clothing", 100.0, LocalDate.of(2023, 5, 18))
        );

        SalesReport report = new SalesReport();

        // Generate full report
        report.generateReport(sales);

        // Generate report for specific product category (e.g., "Clothing")
        report.generateReport(sales, "Clothing");

        // Generate report for a specific date range (e.g., January to March 2023)
        report.generateReport(sales, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 3, 31));
    }
}
