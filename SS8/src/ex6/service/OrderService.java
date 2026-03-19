package ex6.service;


import ex6.factory.SalesChannelFactory;
import ex6.model.Order;
import ex6.strategy.discount.DiscountStrategy;
import ex6.strategy.notification.NotificationService;
import ex6.strategy.payment.PaymentMethod;

public class OrderService {

    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderService(SalesChannelFactory factory) {
        this.discount = factory.createDiscountStrategy();
        this.payment = factory.createPaymentMethod();
        this.notification = factory.createNotificationService();
    }

    public void processOrder(Order order) {
        double total = order.getTotal();
        double finalAmount = discount.applyDiscount(total);
        payment.pay(finalAmount);
        notification.notifyUser("Đơn hàng thành công");
    }
}

