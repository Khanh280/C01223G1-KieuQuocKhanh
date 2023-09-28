package test;

public interface InterfaceA {
    default void display(){
        System.out.println("Hello");
    };
    static  void show(){
        System.out.println("Hi");
    }
}
