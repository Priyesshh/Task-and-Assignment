public class Greeter {

    public static void greet(String name) {
        if (name == null || name.isEmpty()) { // Check for null or empty string
            System.out.println("Hello there!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }

    public static void main(String[] args) {
        greet(null); // calling with no argument/undefined
        greet("Alice");
        greet(""); //empty string
    }
}