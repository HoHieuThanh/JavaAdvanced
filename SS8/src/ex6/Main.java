package ex6;

import ex6.factory.MobileAppFactory;
import ex6.factory.POSFactory;
import ex6.factory.SalesChannelFactory;
import ex6.factory.WebsiteFactory;
import ex6.model.Order;
import ex6.service.OrderService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Chọn kênh:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS");

        int choice = sc.nextInt();
        sc.nextLine();

        SalesChannelFactory factory = null;

        switch (choice) {
            case 1:
                factory = new WebsiteFactory();
                System.out.println("Bạn đã chọn kênh Website");
                break;
            case 2:
                factory = new MobileAppFactory();
                System.out.println("Bạn đã chọn kênh Mobile App");
                break;
            case 3:
                factory = new POSFactory();
                System.out.println("Bạn đã chọn kênh POS");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
                return;
        }

        System.out.print("Nhập tên sản phẩm: ");
        String product = sc.nextLine();

        System.out.print("Giá: ");
        double price = sc.nextDouble();

        System.out.print("Số lượng: ");
        int quantity = sc.nextInt();

        Order order = new Order(product, price, quantity);

        OrderService service = new OrderService(factory);
        service.processOrder(order);
    }
}
