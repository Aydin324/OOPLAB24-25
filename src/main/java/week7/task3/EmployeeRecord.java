package week7.task3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public record EmployeeRecord(String name, String position, double salary, LocalDate employmentDate, String department) {

    // Static method to create an intern with default values
    public static EmployeeRecord createIntern(String name) {
        return new EmployeeRecord(name, "Intern", 30000, LocalDate.now(), "Unassigned");
    }

    // Method to check if the employee has been with the company for more than 5 years
    public boolean isOverFiveYears() {
        long years = ChronoUnit.YEARS.between(employmentDate, LocalDate.now());
        return years > 5;
    }

    // Static method to filter employees who have been with the company for over five years
    public static List<EmployeeRecord> filterEmployeesOverFiveYears(List<EmployeeRecord> employees) {
        return employees.stream()
                .filter(EmployeeRecord::isOverFiveYears)
                .collect(Collectors.toList());
    }

    // Static method to calculate the average salary of employees in a given department
    public static double calculateAverageSalary(List<EmployeeRecord> employees, String department) {
        return employees.stream()
                .filter(employee -> employee.department().equals(department))
                .mapToDouble(EmployeeRecord::salary)
                .average()
                .orElse(0.0);
    }

    // Static method to find and print employees in a specific role (e.g., "Senior Developer")
    public static List<EmployeeRecord> findEmployeesByRole(List<EmployeeRecord> employees, String role) {
        return employees.stream()
                .filter(employee -> employee.position().equals(role))
                .collect(Collectors.toList());
    }
}
