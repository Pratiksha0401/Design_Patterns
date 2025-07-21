package org.example.creational;

/**
 * Vehicle is the product interface in the Factory Design Pattern.
 * It defines the common method that all vehicle types must implement.
 */
interface Vehicle {
    void displayVehicle();
}

/**
 * TwoWheeler is a concrete implementation of the Vehicle interface.
 */
class TwoWheeler implements Vehicle {
    @Override
    public void displayVehicle() {
        System.out.println("I am Two Wheeler");
    }
}

/**
 * FourWheeler is another concrete implementation of the Vehicle interface.
 */
class FourWheeler implements Vehicle {
    @Override
    public void displayVehicle() {
        System.out.println("I am Four Wheeler");
    }
}

/**
 * VehicleFactory is the factory interface that declares the factory method.
 * It defines how to create Vehicle objects without specifying their concrete classes.
 */
interface VehicleFactory {
    Vehicle getVehicle();  // Factory method
}

/**
 * TwoWheelerFactory is a concrete factory that creates TwoWheeler instances.
 */
class TwoWheelerFactory implements VehicleFactory {
    @Override
    public Vehicle getVehicle() {
        return new TwoWheeler();
    }
}

/**
 * FourWheelerFactory is a concrete factory that creates FourWheeler instances.
 */
class FourWheelerFactory implements VehicleFactory {
    @Override
    public Vehicle getVehicle() {
        return new FourWheeler();
    }
}

/**
 * FactoryDP demonstrates the use of the Factory Design Pattern.
 * It decouples object creation from its usage by using factory interfaces.
 */
public class FactoryDP {
    public static void main(String[] args) {
        // Using FourWheelerFactory to create a FourWheeler
        VehicleFactory factory = new FourWheelerFactory();
        Vehicle vehicle = factory.getVehicle();
        vehicle.displayVehicle();  // Output: I am Four Wheeler

        // Using TwoWheelerFactory to create a TwoWheeler
        VehicleFactory factory1 = new TwoWheelerFactory();
        Vehicle vehicle1 = factory1.getVehicle();
        vehicle1.displayVehicle(); // Output: I am Two Wheeler
    }
}
