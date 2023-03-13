package inheritance_oop.triangle;

public class Shape {
    private String color;

    protected Shape(){
    }

    protected Shape(String color){
        this.color = color;
    }

    protected String getColor(){
        return this.color;
    }

    protected void setColor(String color){
        this.color = color;
    }

    @Override
    public String toString() {
        return "Color= " + color;
    }
}
