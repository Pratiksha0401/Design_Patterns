package org.example;

/**
 * A multithreaded printer application that prints numbers from 1 to max
 * using three threads in a specific sequence: Thread-1, Thread-2, and Thread-3.
 * Each thread prints a number only when it's their turn.
 */
public class App {

    /** The maximum number to print. */
    private final int max;

    /** The current number to be printed. */
    private int number = 1;

    /**
     * The current thread's turn.
     * Values: 1 = Thread-1, 2 = Thread-2, 3 = Thread-3
     */
    private int turn = 1;

    /**
     * Constructs the printer with a given maximum number.
     *
     * @param max the maximum number to be printed
     */
    public App(int max) {
        this.max = max;
    }

    /**
     * Prints numbers in sequence for the given thread ID.
     * Only the thread whose turn matches the current turn will print the number.
     * After printing, it updates the turn and notifies other threads.
     *
     * @param threadId the ID of the calling thread (1, 2, or 3)
     */
    public void print(int threadId) {
        while (true) {
            synchronized (this) {
                // Wait until it's this thread's turn
                while (number <= max && turn != threadId) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                // Exit if the number has exceeded the max
                if (number > max) {
                    notifyAll(); // Prevent other threads from waiting forever
                    break;
                }

                // Print the number with thread label
                System.out.println("THREAD-" + threadId + " : " + number++);

                // Determine the next thread's turn: 1 → 2 → 3 → 1 ...
                turn = threadId % 3 + 1;

                // Notify all threads after updating the turn
                notifyAll();
            }
        }
    }

    /**
     * Main method to start three threads that take turns printing numbers.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int N = 10;
        App printer = new App(N);

        Runnable task1 = () -> printer.print(1);
        Runnable task2 = () -> printer.print(2);
        Runnable task3 = () -> printer.print(3);

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
    }

    /**
     * THREAD-1 : 1
     * THREAD-2 : 2
     * THREAD-3 : 3
     * THREAD-1 : 4
     * THREAD-2 : 5
     * THREAD-3 : 6
     * THREAD-1 : 7
     * THREAD-2 : 8
     * THREAD-3 : 9
     * THREAD-1 : 10
     *
     * **/
}
