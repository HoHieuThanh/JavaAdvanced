package ex6.util;

import ex6.presentation.DiscountStrategy;
import ex6.presentation.NotificationService;
import ex6.presentation.PaymentMethod;

public interface SalesChannelFactory {

    DiscountStrategy createDiscount();

    PaymentMethod createPayment();

    NotificationService createNotification();
}

