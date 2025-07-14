package org.example;
import java.util.HashMap;
import java.util.Map;

/**
 * GibberishDetector is a utility to detect gibberish Virtual Payment Addresses (VPAs)
 * based on average Euclidean keyboard distance between consecutive characters.
 *
 * This is based on a simulated QWERTY layout, and is helpful in filtering out
 * randomly typed or spammy-looking user inputs.
 */
public class GibberishValidation {

    // Define keyboard layout as (x, y) positions for a QWERTY keyboard
    private static final Map<Character, int[]> KEYBOARD_MAP = new HashMap<>();

    static {
        // Row 0 (digits and symbols)
        KEYBOARD_MAP.put('1', new int[]{0, 0}); KEYBOARD_MAP.put('2', new int[]{1, 0});
        KEYBOARD_MAP.put('3', new int[]{2, 0}); KEYBOARD_MAP.put('4', new int[]{3, 0});
        KEYBOARD_MAP.put('5', new int[]{4, 0}); KEYBOARD_MAP.put('6', new int[]{5, 0});
        KEYBOARD_MAP.put('7', new int[]{6, 0}); KEYBOARD_MAP.put('8', new int[]{7, 0});
        KEYBOARD_MAP.put('9', new int[]{8, 0}); KEYBOARD_MAP.put('0', new int[]{9, 0});
        KEYBOARD_MAP.put('-', new int[]{10, 0}); KEYBOARD_MAP.put('_', new int[]{10, 0});

        // Row 1 (Q to P)
        KEYBOARD_MAP.put('q', new int[]{0, 1}); KEYBOARD_MAP.put('w', new int[]{1, 1});
        KEYBOARD_MAP.put('e', new int[]{2, 1}); KEYBOARD_MAP.put('r', new int[]{3, 1});
        KEYBOARD_MAP.put('t', new int[]{4, 1}); KEYBOARD_MAP.put('y', new int[]{5, 1});
        KEYBOARD_MAP.put('u', new int[]{6, 1}); KEYBOARD_MAP.put('i', new int[]{7, 1});
        KEYBOARD_MAP.put('o', new int[]{8, 1}); KEYBOARD_MAP.put('p', new int[]{9, 1});

        // Row 2 (A to L)
        KEYBOARD_MAP.put('a', new int[]{0, 2}); KEYBOARD_MAP.put('s', new int[]{1, 2});
        KEYBOARD_MAP.put('d', new int[]{2, 2}); KEYBOARD_MAP.put('f', new int[]{3, 2});
        KEYBOARD_MAP.put('g', new int[]{4, 2}); KEYBOARD_MAP.put('h', new int[]{5, 2});
        KEYBOARD_MAP.put('j', new int[]{6, 2}); KEYBOARD_MAP.put('k', new int[]{7, 2});
        KEYBOARD_MAP.put('l', new int[]{8, 2});

        // Row 3 (Z to M)
        KEYBOARD_MAP.put('z', new int[]{0, 3}); KEYBOARD_MAP.put('x', new int[]{1, 3});
        KEYBOARD_MAP.put('c', new int[]{2, 3}); KEYBOARD_MAP.put('v', new int[]{3, 3});
        KEYBOARD_MAP.put('b', new int[]{4, 3}); KEYBOARD_MAP.put('n', new int[]{5, 3});
        KEYBOARD_MAP.put('m', new int[]{6, 3}); KEYBOARD_MAP.put('.', new int[]{8, 3});
    }

    /**
     * Determines if a given VPA appears to be gibberish based on average
     * keyboard distance between adjacent characters.
     *
     * @param vpa       the virtual payment address (e.g., "asdfqwer@oksbi")
     * @param threshold the cutoff value to determine gibberish (typically ~1.5)
     * @return true if the VPA is considered gibberish; false otherwise
     */
    public static boolean isGibberish(String vpa, double threshold) {
        String vpaPart = vpa.split("@")[0].toLowerCase(); // Take the part before '@'
        double totalDistance = 0.0;
        int pairs = 0;

        for (int i = 0; i < vpaPart.length() - 1; i++) {
            char c1 = vpaPart.charAt(i);
            char c2 = vpaPart.charAt(i + 1);
            if (KEYBOARD_MAP.containsKey(c1) && KEYBOARD_MAP.containsKey(c2)) {
                int[] pos1 = KEYBOARD_MAP.get(c1);
                int[] pos2 = KEYBOARD_MAP.get(c2);
                int dx = pos1[0] - pos2[0];
                int dy = pos1[1] - pos2[1];
                double distance = Math.sqrt(dx * dx + dy * dy);
                totalDistance += distance;
                pairs++;
            }
        }

        if (pairs == 0) return false; // Not enough info to evaluate

        double avgDistance = totalDistance / pairs;
        System.out.printf("Average QWERTY Distance: %.2f%n", avgDistance);
        return avgDistance < threshold;
    }

    /**
     * Sample test to run gibberish detection on a test VPA.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String testVpa = "asdfqwer@oksbi";
        double threshold = 1.5;
        boolean result = isGibberish(testVpa, threshold);
        System.out.println("Is Gibberish: " + result);
        boolean result1 = isGibberish("testvpa@gmail.com", threshold);
        System.out.println("Is Gibberish: " + result1);
    }
}
