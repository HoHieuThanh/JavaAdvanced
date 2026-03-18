import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        while (true) {
            System.out.println("""
                    ---------- QUẢN LÝ SẢN PHẨM ----------
                    1. Thêm mới sản phẩm
                    2. Xem danh sách sản phẩm
                    3. Cập nhật thông tin sản phẩm
                    4. Xoá sản phẩm
                    5. Thoát
                    --------------------------------------
                    Lựa chọn:
                    """);

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("""
                                --------------------------------
                                1. Sản phẩm vật lý
                                2, Sản phẩm kỹ thuật số
                                0. Thoát
                                --------------------------------
                                Lựa chọn: """);
                    int type = Integer.parseInt(sc.nextLine());

                    Product p = ProductFactory.createProduct(type, sc);
                    db.addProduct(p);
                    break;

                case 2:
                    db.displayAll();
                    break;

                case 3:
                    System.out.print("Nhập ID cần sửa: ");
                    db.updateProduct(sc.nextLine(), sc);
                    break;

                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    db.deleteProduct(sc.nextLine());
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        }
    }
}