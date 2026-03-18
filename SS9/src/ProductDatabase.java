import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products;

    private ProductDatabase() {
        products = new ArrayList<>();
    }

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Thêm thành công.");
    }

    public void displayAll() {
        if (products.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        for (Product p : products) {
            p.displayInfo();
        }
    }

    public void deleteProduct(String id) {
        products.removeIf(p -> p.getId().equals(id));
        System.out.println("Đã xóa sản phẩm.");
    }

    public void updateProduct(String id, Scanner sc) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                System.out.print("Nhập tên mới: ");
                p.name = sc.nextLine();
                System.out.print("Nhập giá mới: ");
                p.price = Double.parseDouble(sc.nextLine());
                System.out.println("Cập nhật thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm.");
    }
}
