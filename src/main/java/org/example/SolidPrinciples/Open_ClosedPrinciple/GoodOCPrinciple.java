package org.example.SolidPrinciples.Open_ClosedPrinciple;
import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates a correct implementation of the Open/Closed Principle.
 *
 * New customer types can be added by creating new classes that implement
 * the DiscountStrategy interface, without modifying the existing logic.
 */
public class GoodOCPrinciple {

    public static void main(String[] args) {
        Discount regularDiscount = new RegularDiscount();
        Discount premiumDiscount = new PremiumDiscount();

        DiscountCalculator calculator = new DiscountCalculator();

        double regularDiscountAmount = calculator.calculateDiscount(regularDiscount, 100);
        double premiumDiscountAmount = calculator.calculateDiscount(premiumDiscount, 100);

        System.out.println("Regular Discount: " + regularDiscountAmount);
        System.out.println("Premium Discount: " + premiumDiscountAmount);
    }
}

/**
 * Abstract base class representing a discount strategy.
 */
interface Discount {
    /**
     * Calculates the discount based on amount.
     *
     * @param amount the original amount
     * @return the discount amount
     */
    double calculate(double amount);
}

/**
 * Discount strategy for regular customers (10% discount).
 */
class RegularDiscount implements Discount {
    @Override
    public double calculate(double amount) {
        return amount * 0.10;
    }
}

/**
 * Discount strategy for premium customers (20% discount).
 */
class PremiumDiscount implements Discount {
    @Override
    public double calculate(double amount) {
        return amount * 0.20;
    }
}

/**
 * Calculator class that applies the given discount strategy.
 */
class DiscountCalculator {
    /**
     * Calculates the discount using the provided discount strategy.
     *
     * @param discount the discount strategy
     * @param amount   the purchase amount
     * @return the discount amount
     */
    public double calculateDiscount(Discount discount, double amount) {
        return discount.calculate(amount);
    }
}
