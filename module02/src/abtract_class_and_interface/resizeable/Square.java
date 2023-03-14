package abtract_class_and_interface.resizeable;

public class Square extends Shape{
    private  double a;

    public Square(){
    }

    public Square(double a) {
        this.a = a;
    }

    public Square(String color, boolean filled, double a) {
        super(color, filled);
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public double getArea() {
        return this.a * this.a;
    }

    @Override
    public void resize(double percent) {
        this.setA(this.getA() + (this.getA() * percent) / 100);
    }

    @Override
    public String toString(){
        return "Square Area= " + this.getArea();
    }
}
