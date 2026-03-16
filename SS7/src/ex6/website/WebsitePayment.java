package ex6.website;

import ex6.presentation.PaymentMethod;

public class WebsitePayment implements PaymentMethod {

    public void pay(double amount) {

        System.out.println(
                "Xử lý thanh toán thẻ tín dụng qua cổng thanh toán online: "
                        + amount);
    }
}

