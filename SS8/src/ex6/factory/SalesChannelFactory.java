package ex6.factory;

import ex6.strategy.discount.DiscountStrategy;
import ex6.strategy.notification.NotificationService;
import ex6.strategy.payment.PaymentMethod;

public interface SalesChannelFactory {
    DiscountStrategy createDiscountStrategy();
    PaymentMethod createPaymentMethod();
    NotificationService createNotificationService();
}
