package org.example.creational;

/**
 * Product A: Car - defines a common interface for all car types.
 */
interface Car {
    void assemble();
}

/**
 * Concrete Product A1: Kia Car
 */
class Kia implements Car {
    public void assemble() {
        System.out.println("Car: Assembling Kia Car");
    }
}

/**
 * Concrete Product A2: Hyundai Car
 */
class Hyundai implements Car {
    public void assemble() {
        System.out.println("Car: Assembling Hyundai Car");
    }
}

/**
 * Product B: CarSpecifications - defines a common interface for all region-specific car specifications.
 */
interface CarSpecifications {
    void display();
}

/**
 * Concrete Product B1: South Indian specifications
 */
class SouthIndiaCarSpecification implements CarSpecifications {
    public void display() {
        System.out.println("Specification: Optimized for hot climate, coastal regions, and curved roads.");
    }
}

/**
 * Concrete Product B2: North Indian specifications
 */
class NorthIndiaCarSpecification implements CarSpecifications {
    public void display() {
        System.out.println("Specification: Designed for cold weather, plains, and rough terrain.");
    }
}

/**
 * Abstract Factory: CarFactory - declares methods to create families of related objects (Car + Specification)
 */
interface CarFactory {
    Car getCar();
    CarSpecifications getSpecification();
}

/**
 * Concrete Factory 1: South India Car Factory
 */
class SouthIndiaCarFactory implements CarFactory {
    public Car getCar() {
        return new Kia();
    }

    public CarSpecifications getSpecification() {
        return new SouthIndiaCarSpecification();
    }
}

/**
 * Concrete Factory 2: North India Car Factory
 */
class NorthIndianCarFactory implements CarFactory {
    public Car getCar() {
        return new Hyundai();
    }

    public CarSpecifications getSpecification() {
        return new NorthIndiaCarSpecification();
    }
}

/**
 * Client: Uses Abstract Factory to create products without knowing their concrete classes.
 */
public class AbstractFactoryDP {
    public static void main(String[] args) {

        System.out.println("=== South India Car Factory ===");
        CarFactory southFactory = new SouthIndiaCarFactory(); // uses ConcreteFactory1
        Car southCar = southFactory.getCar(); // ConcreteProductA1
        CarSpecifications southSpecs = southFactory.getSpecification(); // ConcreteProductB1
        southCar.assemble();
        southSpecs.display();

        System.out.println("\n=== North India Car Factory ===");
        CarFactory northFactory = new NorthIndianCarFactory(); // uses ConcreteFactory2
        Car northCar = northFactory.getCar(); // ConcreteProductA2
        CarSpecifications northSpecs = northFactory.getSpecification(); // ConcreteProductB2
        northCar.assemble();
        northSpecs.display();
    }
}
