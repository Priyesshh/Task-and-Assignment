public class Calculator {

    public static void main(String[] args) {
        // naming variables as num1 and num2 so that it is easier to undestand that this variables are used to store number
        int num1 = 10;
        int num2 = 20;
        // naminf variable as sum to imply that this stores sumation of 2 numbers
        int sum = add(num1, num2);

        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
    }

    // A function to add both numbers
    public static int add(int x, int y) {
        return x + y;
    }
}