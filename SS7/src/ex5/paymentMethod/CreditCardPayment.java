package ex5.paymentMethod;

public class CreditCardPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Thanh toán thẻ tín dụng: " + amount);
    }

    public String getName() {
        return "Thẻ tín dụng";
    }
}
