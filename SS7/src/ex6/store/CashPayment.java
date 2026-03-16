package ex6.store;

import ex6.presentation.PaymentMethod;

public class CashPayment implements PaymentMethod {

    public void pay(double amount) {

        System.out.println(
                "Thanh toán tiền mặt tại quầy: " + amount);
    }
}
