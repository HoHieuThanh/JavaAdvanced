package ex6.website;

import ex6.presentation.NotificationService;

public class EmailNotification implements NotificationService {

    public void notifyCustomer(String message) {

        System.out.println("Gửi email xác nhận: " + message);
    }
}
