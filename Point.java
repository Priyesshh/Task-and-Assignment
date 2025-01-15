public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void display() {
        System.out.println("x = " + x + ", y = " + y);
    }

    public static void main(String[] args) {
        Point pt = new Point(10, 20);
        pt.display();
    }
}