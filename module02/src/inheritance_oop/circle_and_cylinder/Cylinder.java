package inheritance_oop.circle_and_cylinder;

public class Cylinder extends Circle {
    private double height;

    protected Cylinder() {
    }

    protected Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    protected double getHeight() {
        return height;
    }

    protected void setHeight(double height) {
        this.height = height;
    }

    protected double getVolume() {
        return this.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Radius = " + this.getRadius() + "\nColor = " + this.getColor() +
                "\nArea = " + this.getArea() + "\nHeight = " + this.height +
                "\nVolume = " + this.getVolume();
    }
}
