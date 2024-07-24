import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollSystem {
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Payroll System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee Details");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Update Employee Allowance");
            System.out.println("5. Generate Payroll");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployeeDetails();
                    break;
                case 3:
                    updateEmployeeSalary();
                    break;
                case 4:
                    updateEmployeeAllowance();
                    break;
                case 5:
                    generatePayroll();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        scanner.close(); // Close the scanner when done
    }

    private static void addEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        double salary = 0.0;
        boolean validSalary = false;
        while (!validSalary) {
            try {
                System.out.print("Enter employee salary: ");
                salary = scanner.nextDouble();
                validSalary = true; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for salary.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        double allowance = 0.0;
        boolean validAllowance = false;
        while (!validAllowance) {
            try {
                System.out.print("Enter employee allowance: ");
                allowance = scanner.nextDouble();
                validAllowance = true; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for allowance.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        Employee emp = new Employee(id, name, salary, allowance);
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    private static void viewEmployeeDetails() {
        System.out.println("Employee Details:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    private static void updateEmployeeSalary() {
        System.out.print("Enter employee ID to update salary: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.print("Enter new salary: ");
                double newSalary = scanner.nextDouble();
                emp.setSalary(newSalary);
                System.out.println("Salary updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found with ID " + id);
        }
    }

    private static void updateEmployeeAllowance() {
        System.out.print("Enter employee ID to update allowance: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.print("Enter new allowance: ");
                double newAllowance = scanner.nextDouble();
                emp.setAllowance(newAllowance);
                System.out.println("Allowance updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found with ID " + id);
        }
    }

    private static void generatePayroll() {
        System.out.println("Payroll Report:");
        for (Employee emp : employees) {
            double totalSalary = emp.getSalary() + emp.getAllowance();
            System.out.println("Employee ID: " + emp.getId());
            System.out.println("Employee Name: " + emp.getName());
            System.out.println("Total Salary: " + totalSalary);
            System.out.println("--------------------------------");
        }
    }
}
