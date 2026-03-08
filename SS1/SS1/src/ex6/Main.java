package ex6;

import ex3.User;
import ex5.InvalidAgeException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        User user = new User();

        try {

            System.out.print("Nhập tên: ");
            String name = sc.nextLine();

            user.setName(name);

            System.out.print("Nhập năm sinh: ");
            String input = sc.nextLine();

            int birthYear = Integer.parseInt(input);
            int age = 2026 - birthYear;

            user.setAge(age);

            user.display();

            // chia nhóm
            System.out.print("Tổng số người: ");
            int total = sc.nextInt();

            System.out.print("Số nhóm: ");
            int groups = sc.nextInt();

            int result = total / groups;

            System.out.println("Mỗi nhóm có: " + result + " người");

            // ghi file
            UserService.processUser(user);

        }

        catch (NumberFormatException e) {

            Logger.logError("Năm sinh phải là số!");

        }

        catch (ArithmeticException e) {

            Logger.logError("Không thể chia cho 0!");

        }

        catch (InvalidAgeException e) {

            Logger.logError(e.getMessage());

        }

        catch (IOException e) {

            Logger.logError("Lỗi ghi file: " + e.getMessage());

        }

        finally {

            sc.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }

        System.out.println("Chương trình kết thúc an toàn.");
    }
}
