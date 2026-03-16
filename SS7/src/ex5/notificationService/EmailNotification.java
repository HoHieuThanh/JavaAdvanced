package ex5.notificationService;

public class EmailNotification implements NotificationService {

    public void send(String message, String to) {
        System.out.println("Đã gửi email xác nhận");
    }
}

