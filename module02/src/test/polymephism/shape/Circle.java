package test.polymephism.shape;

public class Circle extends Shape{
    double radius = 1.0;

    public Circle(){
    }

    public Circle (String color, boolean filled){
        super(color, filled);
    }

    public Circle(String color, boolean filled, double radius){
        super(color, filled);
        this.radius =radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    public  double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "A Circle with radiu" + getRadius() + " which is a subclass of " + super.toString();
    }
}
