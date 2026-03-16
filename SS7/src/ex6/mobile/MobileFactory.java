package ex6.mobile;

import ex6.presentation.DiscountStrategy;
import ex6.presentation.NotificationService;
import ex6.presentation.PaymentMethod;
import ex6.util.SalesChannelFactory;

public class MobileFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new MobileFirstOrderDiscount();
    }

    public PaymentMethod createPayment() {
        return new MomoPayment();
    }

    public NotificationService createNotification() {
        return new PushNotification();
    }
}

