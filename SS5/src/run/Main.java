package run;

import exception.InvalidProductException;
import service.ProductManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager();

        int choice;

        do {

            System.out.println("""
                    ========= PRODUCT MANAGEMENT SYSTEM =========
                    1. Thêm sản phẩm mới
                    2. Hiển thị danh sách sản phẩm
                    3. Cập nhật số lượng theo ID
                    4. Xóa sản phẩm đã hết hàng
                    5. Thoát chương trình
                    =============================================
                    Lựa chọn của bạn:""");
            choice = Integer.parseInt(scanner.nextLine());
            try {

                switch (choice) {

                    case 1:

                        System.out.print("Nhập id: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nhập tên: ");
                        String name = scanner.nextLine();

                        System.out.print("Nhap loại sản phẩm: ");
                        String category = scanner.nextLine();

                        System.out.print("Nhập giá: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        System.out.print("Nhập số lượng: ");
                        int quantity = Integer.parseInt(scanner.nextLine());

                        manager.addProduct(id, name, price, quantity, category);

                        System.out.println("Thêm thành công");
                        break;


                    case 2:
                        manager.displayProducts();
                        break;

                    case 3:

                        System.out.print("Nhập id cần cập nhật: ");
                        int updateId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nhập số lượng mới: ");
                        int newQuantity = Integer.parseInt(scanner.nextLine());

                        manager.updateQuantity(updateId, newQuantity);

                        System.out.println("Cập nhật thành công");
                        break;

                    case 4:

                        System.out.print("Nhập id cần xóa: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        manager.deleteProduct(deleteId);

                        System.out.println("Xóa thành công");
                        break;

                    default:
                        System.out.println("Không hợp lệ");
                }

            } catch (InvalidProductException e) {

                System.out.println("Lỗi: " + e.getMessage());

            }

        } while (choice != 0);

    }
}
