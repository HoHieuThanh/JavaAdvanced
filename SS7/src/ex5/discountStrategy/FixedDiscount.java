package ex5.discountStrategy;

public class FixedDiscount implements DiscountStrategy {

    private double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    public double applyDiscount(double total) {
        return total - amount;
    }

    public String getName() {
        return "Giảm cố định";
    }
}
