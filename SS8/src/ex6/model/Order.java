package ex6.model;

public class Order {
    private String product;
    private double price;
    private int quantity;

    public Order(String product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }
}
