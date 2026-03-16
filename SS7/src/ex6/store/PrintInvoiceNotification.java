package ex6.store;

import ex6.presentation.NotificationService;

public class PrintInvoiceNotification implements NotificationService {

    public void notifyCustomer(String message) {

        System.out.println("In hóa đơn giấy: " + message);
    }
}
