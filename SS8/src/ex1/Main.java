package ex1;

import ex1.factory.AirConditionerFactory;
import ex1.factory.DeviceFactory;
import ex1.factory.FanFactory;
import ex1.factory.LightFactory;
import ex1.model.Device;
import ex1.singleton.HardwareConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Device> devices = new ArrayList<>();
        HardwareConnection connection = null;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị mới");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    connection = HardwareConnection.getInstance();
                    break;

                case 2:
                    System.out.println("Chọn loại thiết bị:");
                    System.out.println("1. Đèn");
                    System.out.println("2. Quạt");
                    System.out.println("3. Điều hòa");
                    int type = scanner.nextInt();

                    DeviceFactory factory = null;

                    switch (type) {
                        case 1:
                            factory = new LightFactory();
                            break;
                        case 2:
                            factory = new FanFactory();
                            break;
                        case 3:
                            factory = new AirConditionerFactory();
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                            continue;
                    }

                    Device device = factory.createDevice();
                    devices.add(device);
                    break;

                case 3:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị nào.");
                        break;
                    }
                    System.out.print("Chọn thiết bị (1 -> " + devices.size() + "): ");
                    int onIndex = scanner.nextInt() - 1;
                    devices.get(onIndex).turnOn();
                    break;

                case 4:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị nào.");
                        break;
                    }
                    System.out.print("Chọn thiết bị (1 -> " + devices.size() + "): ");
                    int offIndex = scanner.nextInt() - 1;
                    devices.get(offIndex).turnOff();
                    break;

                case 5:
                    System.out.println("Đang thoát chương trình...");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
