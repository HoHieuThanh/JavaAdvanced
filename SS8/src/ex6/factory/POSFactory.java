package ex6.factory;


import ex6.strategy.discount.DiscountStrategy;
import ex6.strategy.discount.MemberDiscount;
import ex6.strategy.notification.NotificationService;
import ex6.strategy.notification.PrintReceipt;
import ex6.strategy.payment.CODPayment;
import ex6.strategy.payment.PaymentMethod;

public class POSFactory implements SalesChannelFactory {

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new MemberDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CODPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new PrintReceipt();
    }
}

