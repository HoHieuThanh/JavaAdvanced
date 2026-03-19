package ex6.factory;

import ex6.strategy.discount.DiscountStrategy;
import ex6.strategy.discount.FirstTimeDiscount;
import ex6.strategy.notification.NotificationService;
import ex6.strategy.notification.PushNotification;
import ex6.strategy.payment.MomoPayment;
import ex6.strategy.payment.PaymentMethod;

public class MobileAppFactory implements SalesChannelFactory {

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new FirstTimeDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new MomoPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new PushNotification();
    }
}
