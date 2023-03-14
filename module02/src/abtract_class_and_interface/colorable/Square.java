package abtract_class_and_interface.colorable;

public class Square extends Shape{
    private double a;

    public Square(){
    }

    public Square(double a){
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public void howToColor(){
        System.out.println("Color all four sides.");
    }

    @Override
    public double getArea() {
        return  this.a * this.a;
    }

    @Override
    public String toString() {
        return "Square: " +
                "\na=" + a +
                "\nArea= " + this.getArea();
    }
}
