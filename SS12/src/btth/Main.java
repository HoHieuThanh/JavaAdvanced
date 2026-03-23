package btth;


import btth.repository.PharmacyRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PharmacyRepository repo = new PharmacyRepository();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cập nhật kho");
            System.out.println("2. Tìm thuốc theo giá");
            System.out.println("3. Tính tiền đơn thuốc");
            System.out.println("4. Doanh thu theo ngày");
            System.out.println("5. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    System.out.print("Số lượng thêm: ");
                    int qty = sc.nextInt();

                    repo.updateMedicineStock(id, qty);
                    break;

                case 2:
                    System.out.print("Giá min: ");
                    double min = sc.nextDouble();

                    System.out.print("Giá max: ");
                    double max = sc.nextDouble();

                    repo.findMedicinesByPriceRange(min, max);
                    break;

                case 3:
                    System.out.print("ID đơn thuốc: ");
                    repo.getPrescriptionTotal(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Ngày (yyyy-MM-dd): ");
                    sc.nextLine();
                    String date = sc.nextLine();

                    repo.getDailyRevenue(date);
                    break;

                case 5:
                    return;
            }
        }
    }
}
