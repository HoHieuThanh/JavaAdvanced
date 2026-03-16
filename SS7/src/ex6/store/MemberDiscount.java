package ex6.store;

import ex6.presentation.DiscountStrategy;

public class MemberDiscount implements DiscountStrategy {

    public double applyDiscount(double amount) {

        System.out.println("Áp dụng giảm giá 5% cho khách thành viên");

        return amount * 0.95;
    }
}

