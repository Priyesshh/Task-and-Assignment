public class Calculator2{

    int add(int x, int y) {
        return x + y;
    }

    int subtract(int x, int y) {
        return x - y; // Corrected subtraction
    }

    public static void main(String[] args) {
        Calculator2 c = new Calculator2();

        int sum = c.add(10, 5); // Store the result of addition
        int difference = c.subtract(20, 8); // Store the result of subtraction
        int result = sum + difference; // Calculate the final result

        System.out.println("Result: " + result);
    }
}