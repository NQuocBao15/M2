package abstractex;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Circle(5.0);
        Shape shape2 = new Rectangle(4.0, 6.0);

        System.out.println("Area: " + shape1.getArea());

        System.out.println("Area: " + shape2.getArea());
    }
}
