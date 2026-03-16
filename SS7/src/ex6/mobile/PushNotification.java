package ex6.mobile;

import ex6.presentation.NotificationService;

public class PushNotification implements NotificationService {

    public void notifyCustomer(String message) {

        System.out.println("Gửi push notification: " + message);
    }
}

