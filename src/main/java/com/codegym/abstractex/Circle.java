package com.codegym.abstractex;

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void printInfo() {
        System.out.println("This is a circle with radius " + radius);
    }
}
