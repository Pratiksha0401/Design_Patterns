package org.example.creational;

/**
 * SingletonDesign demonstrates a **lazy-initialized non-thread-safe singleton**.
 * This version is simple but not safe in a multithreaded environment.
 */
class SingletonDesign {

    private static SingletonDesign instance;

    /**
     * Private constructor to prevent instantiation from outside.
     */
    private SingletonDesign() {
        System.out.println("SingletonDesign: Instance created.");
    }

    /**
     * Returns the single instance of SingletonDesign.
     * Lazily initializes the instance on first call.
     * Not thread-safe.
     *
     * @return SingletonDesign instance
     */
    public static SingletonDesign getInstance() {
        if (instance == null) {
            instance = new SingletonDesign();
        }
        return instance;
    }

    /**
     * Sample method demonstrating usage of SingletonDesign.
     */
    public void doSomething() {
        System.out.println("SingletonDesign: Doing something...");
    }
}

/**
 * SingletonDesignPattern demonstrates a **thread-safe singleton using double-checked locking**.
 * This pattern improves performance by minimizing synchronization overhead.
 */
class SingletonDesignPattern {

    // Use of volatile ensures visibility across threads
    private static volatile SingletonDesignPattern obj = null;

    /**
     * Private constructor to prevent instantiation from outside.
     */
    private SingletonDesignPattern() {
        System.out.println("SingletonDesignPattern: Instance created.");
    }

    /**
     * Returns the singleton instance using double-checked locking.
     * This ensures only one instance is created, even in multithreaded environments.
     *
     * @return SingletonDesignPattern instance
     */
    public static SingletonDesignPattern getInstance() {
        if (obj == null) {
            synchronized (SingletonDesignPattern.class) {
                if (obj == null)
                    obj = new SingletonDesignPattern();
            }
        }
        return obj;
    }

    /**
     * Sample method demonstrating usage of SingletonDesignPattern.
     */
    public void doSomething() {
        System.out.println("SingletonDesignPattern: Doing something...");
    }
}

/**
 * SingletonDP demonstrates a **thread-safe singleton using synchronized method**.
 * Easy to implement but may suffer from performance overhead due to locking.
 */
class SingletonDP {

    private static SingletonDP obj;

    /**
     * Private constructor to prevent instantiation from outside.
     */
    private SingletonDP() {
        System.out.println("SingletonDP: Instance created.");
    }

    /**
     * Synchronized method to ensure only one thread can access this method at a time.
     * Slower but thread-safe.
     *
     * @return SingletonDP instance
     */
    public static synchronized SingletonDP getInstance() {
        if (obj == null)
            obj = new SingletonDP();
        return obj;
    }

    /**
     * Sample method demonstrating usage of SingletonDP.
     */
    public void doSomething() {
        System.out.println("SingletonDP: Doing something...");
    }
}

/**
 * Main class to demonstrate different implementations of the Singleton Design Pattern.
 */
public class Singleton {
    public static void main(String[] args) {
        // Lazy, non-thread-safe singleton
        SingletonDesign.getInstance().doSomething();

        // Double-checked locking, thread-safe singleton
        SingletonDesignPattern.getInstance().doSomething();

        // Thread-safe, synchronized singleton
        SingletonDP.getInstance().doSomething();
    }
}
