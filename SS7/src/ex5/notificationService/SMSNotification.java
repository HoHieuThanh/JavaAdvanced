package ex5.notificationService;

public class SMSNotification implements NotificationService {

    public void send(String message, String to) {
        System.out.println("Đã gửi SMS");
    }
}
