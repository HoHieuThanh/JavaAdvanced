package ex5.discountStrategy;

public class HolidayDiscount implements DiscountStrategy {

    public double applyDiscount(double amount) {
        return amount * 0.85;
    }

    public String getName() {
        return "Holiday 15%";
    }
}

