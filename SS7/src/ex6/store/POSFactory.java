package ex6.store;

import ex6.presentation.DiscountStrategy;
import ex6.presentation.NotificationService;
import ex6.presentation.PaymentMethod;
import ex6.util.SalesChannelFactory;

public class POSFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new MemberDiscount();
    }

    public PaymentMethod createPayment() {
        return new CashPayment();
    }

    public NotificationService createNotification() {
        return new PrintInvoiceNotification();
    }
}

