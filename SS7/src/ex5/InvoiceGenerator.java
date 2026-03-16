package ex5;

import ex5.model.Order;
import ex5.model.OrderItem;

public class InvoiceGenerator {

    public void generate(Order order) {

        System.out.println("=== HÓA ĐƠN ===");

        System.out.println("Khách: " + order.getCustomer().getName());

        for (OrderItem item : order.getItems()) {

            System.out.println(
                    item.getProduct().getName()
                            + " - Số lượng: " + item.getQuantity()
                            + " - Thành tiền: " + item.getTotal());
        }

        System.out.println("Cần thanh toán: " + order.getFinalAmount());
    }
}

