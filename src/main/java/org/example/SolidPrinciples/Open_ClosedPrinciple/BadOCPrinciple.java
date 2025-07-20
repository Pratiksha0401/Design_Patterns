package org.example.SolidPrinciples.Open_ClosedPrinciple;

/**
 * This class demonstrates a violation of the Open/Closed Principle.
 *
 * The Open/Closed Principle states that a class should be open for extension but closed for modification.
 * In this example, if we want to add a new customer type (e.g., "Gold", "Platinum"),
 * we would have to modify the `calculateDiscount()` method, which is a violation of OCP.
 */
public class BadOCPrinciple {

    /**
     * Calculates discount based on customer type.
     *
     * BAD PRACTICE:
     * This method uses conditional logic (if-else) that must be changed every time a new customer type is introduced.
     * This makes the code hard to maintain and violates the Open/Closed Principle.
     *
     * @param customerType type of customer (e.g., "Regular", "Premium")
     * @param amount       purchase amount
     * @return the calculated discount
     */
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("Regular")) {
            return amount * 0.1;
        } else if (customerType.equals("Premium")) {
            return amount * 0.2;
        }
        return 0;
    }

    /**
     * Entry point for testing the discount calculation.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        BadOCPrinciple calculator = new BadOCPrinciple();
        double regularDiscount = calculator.calculateDiscount("Regular", 100);
        double premiumDiscount = calculator.calculateDiscount("Premium", 100);

        System.out.println("Regular Discount: " + regularDiscount);
        System.out.println("Premium Discount: " + premiumDiscount);
    }
}
