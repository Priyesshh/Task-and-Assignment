public class Rectangle { 
    private int length;
    private int width;    
    public Rectangle(int length, int width) { 
        this.length = length;
        this.width = width;
    }

    public int calculateArea() {
        return length * width;
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 8);
        System.out.println("Area: " + rect.calculateArea());
    }
}