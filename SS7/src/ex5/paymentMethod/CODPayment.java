package ex5.paymentMethod;

public class CODPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Thanh toán COD: " + amount + " - Thành công");
    }

    public String getName() {
        return "COD";
    }
}

