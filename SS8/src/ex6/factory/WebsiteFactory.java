package ex6.factory;

import ex6.strategy.discount.DiscountStrategy;
import ex6.strategy.discount.WebsiteDiscount;
import ex6.strategy.notification.EmailNotification;
import ex6.strategy.notification.NotificationService;
import ex6.strategy.payment.CreditCardPayment;
import ex6.strategy.payment.PaymentMethod;

public class WebsiteFactory implements SalesChannelFactory {

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new WebsiteDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new EmailNotification();
    }
}

