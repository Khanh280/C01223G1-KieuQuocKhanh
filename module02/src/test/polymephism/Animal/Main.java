package test.polymephism.Animal;

import test.polymephism.Animal.Animal;
import test.polymephism.Animal.Cat;
import test.polymephism.Animal.Dog;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        animal1.makeSound();
        animal2.makeSound();
    }
}
