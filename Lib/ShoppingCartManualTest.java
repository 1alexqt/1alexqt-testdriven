

import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: ซื้อ 1 แถม 1
        ArrayList<CartItem> bogoCart = new ArrayList<>();
        bogoCart.add(new CartItem("BOGO", "Chocolate", 60.0, 4)); // 30 + 30 = 60 (จ่าย 2)
        double total4 = ShoppingCartCalculator.calculateTotalPrice(bogoCart);
        if (total4 == 120.0) {
            System.out.println("PASSED: BOGO cart total is correct (60.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BOGO cart total expected 60.0 but got " + total4);
            failedCount++;
        }

        // Test 5: ส่วนลดเมื่อซื้อเยอะ
        ArrayList<CartItem> bulkCart = new ArrayList<>();
        bulkCart.add(new CartItem("BULK", "Rice", 100.0, 6)); // 600 - 10% = 540
        double total5 = ShoppingCartCalculator.calculateTotalPrice(bulkCart);
        if (total5 == 540.0) {
            System.out.println("PASSED: BULK cart total is correct (540.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BULK cart total expected 540.0 but got " + total5);
            failedCount++;
        }

        // Test 6: การใช้งานร่วมกันของส่วนลด
        ArrayList<CartItem> mixedCart = new ArrayList<>();
        mixedCart.add(new CartItem("BOGO", "Cookies", 50.0, 3)); // 50 + 50 = 100 (จ่าย 2)
        mixedCart.add(new CartItem("BULK", "Flour", 200.0, 7)); // 1400 - 10% = 1260
        double total6 = ShoppingCartCalculator.calculateTotalPrice(mixedCart);
        if (total6 == 1360.0) {
            System.out.println("PASSED: Mixed cart total is correct (1360.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Mixed cart total expected 1360.0 but got " + total6);
            failedCount++;
        }
        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}