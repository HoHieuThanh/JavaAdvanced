package ex5.presentation;


import ex5.business.DoctorService;
import ex5.model.Doctor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorService service = new DoctorService();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    service.showAll();
                    break;

                case 2:
                    System.out.print("Mã: ");
                    String id = sc.nextLine();

                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Chuyên khoa: ");
                    String sp = sc.nextLine();

                    service.add(new Doctor(id, name, sp));
                    break;

                case 3:
                    service.statistic();
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}
