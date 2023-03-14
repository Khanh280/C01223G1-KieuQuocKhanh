package abtract_class_and_interface.resizeable;

public class Circle extends Shape{
    private double radius;

    protected  Circle(){
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    @Override
    public void resize(double percent) {
        this.setRadius(this.getRadius() + (this.getRadius() * percent) / 100);
    }

    @Override
    public String toString() {
        return "Circle Area= " + this.getArea();
    }
}
