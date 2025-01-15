public class Program {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        //using a ternary operator:
        String message = (a < b) ? "a is less than b" : "b is less than or equal to a";
        System.out.println(message);
    }
}