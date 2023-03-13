package test.polymephism.Animal;

import test.polymephism.Animal.Animal;

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Gau Gau");
    }
}
