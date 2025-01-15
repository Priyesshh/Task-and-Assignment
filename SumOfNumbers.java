public class SumOfNumbers {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i]; // Same as sum = sum + numbers[i];
        }

        System.out.println("The sum is: " + sum);
    }
}