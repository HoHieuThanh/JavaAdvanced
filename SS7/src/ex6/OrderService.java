package ex6;

import ex6.presentation.DiscountStrategy;
import ex6.presentation.NotificationService;
import ex6.presentation.PaymentMethod;
import ex6.util.SalesChannelFactory;

public class OrderService {

    private SalesChannelFactory factory;

    public OrderService(SalesChannelFactory factory) {
        this.factory = factory;
    }

    public void createOrder(double amount) {

        DiscountStrategy discount = factory.createDiscount();
        PaymentMethod payment = factory.createPayment();
        NotificationService notify = factory.createNotification();

        double finalAmount = discount.applyDiscount(amount);

        payment.pay(finalAmount);

        notify.notifyCustomer("Đơn hàng thành công");
    }
}

