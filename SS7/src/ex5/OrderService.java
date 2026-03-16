package ex5;

import ex5.discountStrategy.DiscountStrategy;
import ex5.model.Order;
import ex5.model.OrderItem;
import ex5.notificationService.NotificationService;
import ex5.paymentMethod.PaymentMethod;
import ex5.repository.OrderRepository;

public class OrderService {

    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository,
                        NotificationService notification) {

        this.repository = repository;
        this.notification = notification;
    }

    public void createOrder(Order order,
                            DiscountStrategy discount,
                            PaymentMethod payment) {

        double total = 0;

        for (OrderItem item : order.getItems()) {
            total += item.getTotal();
        }

        double finalAmount = discount.applyDiscount(total);

        order.setFinalAmount(finalAmount);

        payment.pay(finalAmount);

        repository.save(order);

        notification.send(
                "Đơn hàng " + order.getId(),
                order.getCustomer().getEmail());
    }
}

