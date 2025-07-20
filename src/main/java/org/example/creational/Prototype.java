package org.example.creational;

/**
 * The Prototype interface declares a cloning method.
 * Any concrete class implementing this interface must provide a copy (clone) of itself.
 */
interface Shape {
    /**
     * Clones the current object.
     *
     * @return a new Shape object which is a copy of the current one
     */
    Shape clone();

    /**
     * Draws the shape.
     */
    void draw();
}

/**
 * Concrete Prototype class: Circle
 * Implements the Shape interface and provides a concrete implementation for cloning.
 */
class Circle implements Shape {
    private String color;

    /**
     * Constructor to create a Circle with a specific color.
     *
     * @param color the color of the circle
     */
    public Circle(String color) {
        this.color = color;
    }

    /**
     * Creates and returns a copy of this Circle object.
     *
     * @return a new Circle object with the same color
     */
    @Override
    public Shape clone() {
        return new Circle(this.color);
    }

    /**
     * Prints the drawing action with the circle's color.
     */
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle.");
    }
}

/**
 * Client class: Uses a Shape prototype to create new shape objects.
 */
class ShapeClient {
    private Shape shapePrototype;

    /**
     * Constructor to initialize the client with a prototype Shape.
     *
     * @param shapePrototype a prototype object that will be used for cloning
     */
    public ShapeClient(Shape shapePrototype) {
        this.shapePrototype = shapePrototype;
    }

    /**
     * Creates a new Shape by cloning the prototype.
     *
     * @return a new cloned Shape object
     */
    public Shape createShape() {
        return shapePrototype.clone();
    }
}

/**
 * Main class to demonstrate the Prototype Design Pattern.
 * This pattern is useful when object creation is costly or complex.
 */
public class Prototype {
    public static void main(String[] args) {
        // Create a concrete prototype (a red circle).
        Shape circlePrototype = new Circle("red");

        // Create a client that uses the prototype.
        ShapeClient client = new ShapeClient(circlePrototype);

        // Use the client to create a copy of the prototype.
        Shape redCircle = client.createShape();

        // Draw the copied shape.
        redCircle.draw();
    }
}
