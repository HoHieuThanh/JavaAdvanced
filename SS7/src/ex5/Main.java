package ex5;

import ex5.discountStrategy.DiscountStrategy;
import ex5.discountStrategy.PercentageDiscount;
import ex5.model.Customer;
import ex5.model.Order;
import ex5.model.OrderItem;
import ex5.model.Product;
import ex5.notificationService.EmailNotification;
import ex5.notificationService.NotificationService;
import ex5.paymentMethod.CreditCardPayment;
import ex5.paymentMethod.PaymentMethod;
import ex5.repository.FileOrderRepository;
import ex5.repository.OrderRepository;

public class Main {

    public static void main(String[] args) {

        Product p1 = new Product(
                "SP01","Laptop",15000000,"Điện tử");

        Customer c1 = new Customer(
                "Nguyễn Văn A",
                "a@example.com",
                "0123456789");

        Order order = new Order("ORD001", c1);

        order.addItem(new OrderItem(p1,1));

        DiscountStrategy discount =
                new PercentageDiscount(10);

        PaymentMethod payment =
                new CreditCardPayment();

        OrderRepository repo =
                new FileOrderRepository();

        NotificationService notify =
                new EmailNotification();

        OrderService service =
                new OrderService(repo, notify);

        service.createOrder(order, discount, payment);

        new InvoiceGenerator().generate(order);
    }
}

