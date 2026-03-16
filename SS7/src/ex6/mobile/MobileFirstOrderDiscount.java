package ex6.mobile;

import ex6.presentation.DiscountStrategy;

public class MobileFirstOrderDiscount implements DiscountStrategy {

    public double applyDiscount(double amount) {

        System.out.println("Áp dụng giảm giá 15% cho lần đầu");

        return amount * 0.85;
    }
}
