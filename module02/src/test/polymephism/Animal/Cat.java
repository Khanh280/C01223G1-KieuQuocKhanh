package test.polymephism.Animal;

import test.polymephism.Animal.Animal;

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meows meows");
    }
}
