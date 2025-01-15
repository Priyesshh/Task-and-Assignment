public class Circle {

    private static final double PI = Math.PI; // Use Math.PI for higher precision

    public static double calculateArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        return PI * radius * radius;
    }

    public static void main(String[] args) {
        double radius = 5;
        double area = calculateArea(radius);
        System.out.println("The area is: " + area);
    }
}
public class Circle {

    private static final double PI = Math.PI; // Use Math.PI for higher precision

    public static double calculateArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        return PI * radius * radius;
    }

    public static void main(String[] args) {
        double radius = 5;
        double area = calculateArea(radius);
        System.out.println("The area is: " + area);
    }
}
    