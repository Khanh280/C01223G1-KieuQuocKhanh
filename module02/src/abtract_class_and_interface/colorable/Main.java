package abtract_class_and_interface.colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[1];
        shapes[0] = new Square(2);
        for (Shape s: shapes) {
            if ( s instanceof Colorable){
                System.out.println(s);
                s.howToColor();
            }
        }
    }
}
