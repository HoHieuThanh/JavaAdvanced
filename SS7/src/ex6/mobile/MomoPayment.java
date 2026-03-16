package ex6.mobile;

import ex6.presentation.PaymentMethod;

public class MomoPayment implements PaymentMethod {

    public void pay(double amount) {

        System.out.println(
                "Xử lý thanh toán MoMo tích hợp: " + amount);
    }
}

