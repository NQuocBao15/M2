package com.codegym.note;

public class Cylinder extends Circle{

    private float height;

    public Cylinder() {
        // ở đây mặc định là nó gọi đi đâu              ???
        // sẽ gọi đến hàm khởi tạo không tham số ở lớp cha Circle
//        super();
    }

    public Cylinder(float height, float radius, String color) {
        // Cách 1: super(radius, color) cái này để làm gì       ??
        // dùng để gọi phương thức khởi tạo của lớp cha radius với color
        super(radius, color);


        // Cách 2:  Vì sao ở đây this.color và this.radius được      ???
        // sử dụng được vì nó sẽ thiết lập giá trị cho trường color và radius ở lớp con Cylinder
//        this.color = color;
//        this.radius = radius;

        // Cách 3:     setColor(color);  vì sao gọi được        ???
        // vì setColor và setRadius là 2 phương thức public ở lớp Circle, lớp Cylinder kế thừa lớp Circle, nên gọi được
//        setColor(color);    // có thể dùng: this.setColor(color);
//        setRadius(radius);

        // cách 4: super.setColor(color); vì sao gọi được       ???
        // giống cách 3, gọi phương thức ở lớp cha
//        super.setColor(color);
//        super.setRadius(radius);

        this.height = height;

    }

    // Tại sao phải ghi đè phương thức getArea()            ???
    // ghi đè lại để tính diện tích của Cylinder, (PI * r^2) * height
    @Override
    public float getArea() {
        // Nếu lấy this.getArea() thì chuyện gì sẽ xảy ra       ???
        // thì sẽ gọi phương thức getArea() ở lớp Cylinder, nên sẽ lấy không đúng giá trị
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return String.format("Cylinder: %s, color: %s, Area: %s",
                this.radius, color, this.getArea() );
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle);

        Cylinder cylinder = new Cylinder(3, 10, "RED");
        System.out.println(cylinder);

        // Ở đây sử dụng tính chất gì, nói ra                       ???
        // tính đa hình
        Circle c1 = new Cylinder(3, 10, "BLUE");

        // c1.getArea();            lấy phương của lớp nào để thực hình             ???
        // lấy phương thức getArea() ở lớp Cylinder vì c1 được tạo ở lớp Cylinder
        float area = c1.getArea();
        System.out.println("Area c1: " + area);
    }
}

