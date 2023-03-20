package com.codegym.abstractex;

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public void printInfo() {
        System.out.println("This is a rectangle with width " + width + " and height " + height);
    }
}
