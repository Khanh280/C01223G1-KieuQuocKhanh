package test.polymephism.shape;

public class Rectanle extends Shape {
    double width = 1.0;
    double length = 1.0;

    public Rectanle(){
    }

    public Rectanle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectanle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth(){
        return this.width;
    }

    public  void setWidth(Double width){
        this.width = width;
    }

    public  double getLength(){
        return  this.length;
    }

    public void setLength( Double length){
        this.length = length;
    }

    public double getArea(){
        return  width * length;
    }

    public double getPerimeter(){
        return 2* (width + length);
    }

    @Override
    public String toString(){
        return "A Rectangle with width= " + getWidth() + " and length= " + getLength() +
                ", which is a subclass of " + super.toString();
    }
}
