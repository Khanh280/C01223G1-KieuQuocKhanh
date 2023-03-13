package inheritance_oop.circle_and_cylinder;

public class Circle {
    private double radius;
    private String color;

    protected Circle() {
    }

    protected Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    protected double getRadius() {
        return this.radius;
    }

    protected void setRadius(double radius) {
        this.radius = radius;
    }

    protected String getColor() {
        return this.color;
    }

    protected void setColor(String color) {
        this.color = color;
    }

    protected double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public String toString() {
        return "Radius = " + this.radius + "\nColor = " + this.color + "\nArea = " + this.getArea();
    }
}
