package ex4;

public class Main {

    public static void main(String[] args) {

        // Cấu hình 1
        OrderRepository repo1 = new FileOrderRepository();
        NotificationService notify1 = new EmailService();

        OrderService service1 = new OrderService(repo1, notify1);

        Order order1 = new Order("ORD001");

        service1.createOrder(order1);


        System.out.println("-------------------");


        // Cấu hình 2
        OrderRepository repo2 = new DatabaseOrderRepository();
        NotificationService notify2 = new SMSNotification();

        OrderService service2 = new OrderService(repo2, notify2);

        Order order2 = new Order("ORD002");

        service2.createOrder(order2);
    }
}

