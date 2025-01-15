public class SumCalculator {

    public static void printSum(int num1, int num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2)); // More informative output
    }

    public static void main(String[] args) {
        printSum(3, 4);
        printSum(10,20); //added another test case
    }
}