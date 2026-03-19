package ex5;

import ex5.command.SleepModeCommand;
import ex5.devide.AirConditioner;
import ex5.devide.Fan;
import ex5.devide.Light;
import ex5.subject.TemperatureSensor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        TemperatureSensor sensor = new TemperatureSensor();
        sensor.attach(fan);
        sensor.attach(ac);

        SleepModeCommand sleepMode = new SleepModeCommand(light, fan, ac);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Kích hoạt chế độ ngủ");
            System.out.println("2. Thay đổi nhiệt độ");
            System.out.println("3. Xem trạng thái thiết bị");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sleepMode.execute();
                    break;

                case 2:
                    System.out.print("Nhập nhiệt độ: ");
                    int temp = sc.nextInt();
                    sensor.setTemperature(temp);
                    break;

                case 3:
                    light.status();
                    fan.status();
                    ac.status();
                    break;

                case 0:
                    return;
            }
        }
    }
}
