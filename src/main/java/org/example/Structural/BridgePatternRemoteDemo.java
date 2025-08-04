package org.example.Structural;

// Implementor - Device interface
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int level);
}

// Concrete Implementor 1 - TV
class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("Turning ON the TV");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning OFF the TV");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("Setting TV volume to " + level);
    }
}

// Concrete Implementor 2 - Radio
class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Turning ON the Radio");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning OFF the Radio");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("Setting Radio volume to " + level);
    }
}

// Abstraction - Remote Control
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    abstract void powerOn();
    abstract void powerOff();
    abstract void volumeUp();
}

// Refined Abstraction 1 - Basic Remote
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    void powerOn() {
        device.turnOn();
    }

    @Override
    void powerOff() {
        device.turnOff();
    }

    @Override
    void volumeUp() {
        device.setVolume(10);
    }
}

// Refined Abstraction 2 - Advanced Remote
class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    void powerOn() {
        System.out.println("Advanced Remote: Powering ON with voice control");
        device.turnOn();
    }

    @Override
    void powerOff() {
        System.out.println("Advanced Remote: Powering OFF with voice control");
        device.turnOff();
    }

    @Override
    void volumeUp() {
        System.out.println("Advanced Remote: Increasing volume gradually...");
        device.setVolume(20);
    }
}

// Client - Demonstration
public class BridgePatternRemoteDemo {
    public static void main(String[] args) {
        // Basic Remote with TV
        RemoteControl tvRemote = new BasicRemote(new TV());
        tvRemote.powerOn();
        tvRemote.volumeUp();
        tvRemote.powerOff();

        System.out.println();

        // Advanced Remote with Radio
        RemoteControl radioRemote = new AdvancedRemote(new Radio());
        radioRemote.powerOn();
        radioRemote.volumeUp();
        radioRemote.powerOff();
    }
}

