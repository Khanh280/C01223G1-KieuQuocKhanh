package abtract_class_and_interface.resizeable;

public class Rectanle extends Shape{
    private double width;
    private double height;
    public Rectanle(){
    }

    public Rectanle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectanle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void resize(double percent) {
        this.setWidth(this.getWidth() + (this.getWidth() * percent) / 100);
        this.setHeight(this.getHeight() + (this.getHeight() * percent) / 100);
    }

    @Override
    public  String toString(){
        return "Rectangle Area= " + this.getArea();
    }
}
