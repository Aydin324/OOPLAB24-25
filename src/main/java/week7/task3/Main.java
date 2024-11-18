package week7.task3;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeeRecord emp1 = new EmployeeRecord("Alice", "Senior Developer", 95000, LocalDate.of(2016, 5, 10), "Engineering");
        EmployeeRecord emp2 = new EmployeeRecord("Bob", "Developer", 75000, LocalDate.of(2019, 3, 22), "Engineering");
        EmployeeRecord emp3 = new EmployeeRecord("Charlie", "Intern", 30000, LocalDate.of(2024, 1, 10), "Unassigned");
        EmployeeRecord emp4 = new EmployeeRecord("Diana", "Senior Developer", 100000, LocalDate.of(2015, 6, 12), "Engineering");

        List<EmployeeRecord> employees = List.of(emp1, emp2, emp3, emp4);

        // Filter employees who have been with the company for over 5 years
        List<EmployeeRecord> overFiveYears = EmployeeRecord.filterEmployeesOverFiveYears(employees);
        System.out.println("Employees with over 5 years of service:");
        overFiveYears.forEach(System.out::println);

        // Calculate the average salary for the "Engineering" department
        double avgSalary = EmployeeRecord.calculateAverageSalary(employees, "Engineering");
        System.out.println("\nAverage Salary in Engineering: " + avgSalary);

        // Find all "Senior Developer" roles
        List<EmployeeRecord> seniorDevelopers = EmployeeRecord.findEmployeesByRole(employees, "Senior Developer");
        System.out.println("\nSenior Developers:");
        seniorDevelopers.forEach(System.out::println);

        // Create an intern and print the details
        EmployeeRecord intern = EmployeeRecord.createIntern("Eve");
        System.out.println("\nCreated Intern: " + intern);

    }
}
