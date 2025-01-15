import java.util.InputMismatchException;
import java.util.Scanner;

public class FencingCostCalculator {

    private static final double SQUARE_RATE = 10;
    private static final double RECTANGLE_RATE = 12;
    private static final double CIRCLE_RATE = 13;

    public static void main(String[] args) { // Corrected args to String[]
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select the shape of the field:");
        System.out.println("1. Square (Rs." + SQUARE_RATE + "/meter)");
        System.out.println("2. Rectangle (Rs." + RECTANGLE_RATE + "/meter)");
        System.out.println("3. Circle (Rs." + CIRCLE_RATE + "/meter)");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    calculateSquareFencingCost(scanner);
                    break;
                case 2:
                    calculateRectangleFencingCost(scanner);
                    break;
                case 3:
                    calculateCircleFencingCost(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Clear invalid input
        } finally {
            scanner.close(); // Close the scanner in a finally block to prevent memory leakage
        }
    }

    private static void calculateSquareFencingCost(Scanner scanner) {
        System.out.println("Enter the length of a side:");
        try {
            double side = getValidDoubleInput(scanner);
            double perimeter = 4 * side;
            double cost = perimeter * SQUARE_RATE;
            printCost(cost);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void calculateRectangleFencingCost(Scanner scanner) {
        System.out.println("Enter the length:");
        try {
            double length = getValidDoubleInput(scanner);
            System.out.println("Enter the breadth:");
            double breadth = getValidDoubleInput(scanner);

            double perimeter = 2 * (length + breadth);
            double cost = perimeter * RECTANGLE_RATE;
            printCost(cost);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void calculateCircleFencingCost(Scanner scanner) {
        System.out.println("Enter the radius:");
        try {
            double radius = getValidDoubleInput(scanner);
            double perimeter = 2 * Math.PI * radius;
            double cost = perimeter * CIRCLE_RATE;
            printCost(cost);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static double getValidDoubleInput(Scanner scanner) {
        try {
            double input = scanner.nextDouble();
            if (input < 0) {
                throw new IllegalArgumentException("Input cannot be negative.");
            }
            return input;
        } catch (InputMismatchException e) {
            scanner.next(); // Clear invalid input from scanner
            throw new IllegalArgumentException("Invalid input. Please enter a valid number.");
        }
    }

    private static void printCost(double cost) {
        System.out.printf("The total cost of fencing is: Rs. %.2f%n", cost); // Formatted output
    }
}