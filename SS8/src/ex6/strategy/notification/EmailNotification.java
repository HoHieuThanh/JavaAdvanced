package ex6.strategy.notification;


public class EmailNotification implements NotificationService {
    @Override
    public void notifyUser(String message) {
        System.out.println("Gửi email: " + message);
    }
}

