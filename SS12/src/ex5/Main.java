package ex5;

import ex5.model.Patient;
import ex5.repository.PatientRepository;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientRepository repo = new PatientRepository();

        while (true) {
            System.out.println("\n=== RHMS MENU ===");
            System.out.println("1. Danh sách bệnh nhân");
            System.out.println("2. Tiếp nhận bệnh nhân");
            System.out.println("3. Cập nhật bệnh án");
            System.out.println("4. Xuất viện & tính phí");
            System.out.println("5. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    List<Patient> list = repo.getAll();
                    for (Patient p : list) {
                        System.out.println(p.getName() + " - " + p.getAge() + " - " + p.getDepartment());
                    }
                    break;

                case 2:
                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Tuổi: ");
                    int age = sc.nextInt(); sc.nextLine();

                    System.out.print("Khoa: ");
                    String dep = sc.nextLine();

                    System.out.print("Bệnh: ");
                    String dis = sc.nextLine();

                    System.out.print("Số ngày: ");
                    int days = sc.nextInt();

                    repo.add(new Patient(name, age, dep, dis, days));
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();

                    System.out.print("Bệnh mới: ");
                    String newDis = sc.nextLine();

                    repo.updateDisease(id, newDis);
                    break;

                case 4:
                    System.out.print("ID: ");
                    int pid = sc.nextInt();

                    repo.discharge(pid);
                    break;

                case 5:
                    return;
            }
        }
    }
}
