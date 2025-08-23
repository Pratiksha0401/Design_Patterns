package org.example.SolidPrinciples.LiskovSubstitutionPrinciple;

public class BadLSP {
  public static void main(String[] args) {
        Bird bird = new Sparrow();
        bird.fly(); // Output: Sparrow is flying

        bird = new Penguin();
        bird.fly(); // Throws UnsupportedOperationException
    }
}


class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}

