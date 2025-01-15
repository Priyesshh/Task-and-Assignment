public class Multiplier {

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static void main(String[] args) {
        int result = multiply(3, 5);
        System.out.println("The result of 3 * 5 is: " + result);

        // Extra test cases
        System.out.println("The result of 2 * 10 is: " + multiply(2, 10));
        System.out.println("The result of -4 * 6 is: " + multiply(-4, 6));

    }
}