package ex3;

import ex3.command.*;
import ex3.device.AirConditioner;
import ex3.device.Fan;
import ex3.device.Light;
import ex3.remote.RemoteControl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Gán command");
            System.out.println("2. Nhấn nút");
            System.out.println("3. Undo");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Chọn nút: ");
                    int slot = sc.nextInt();

                    System.out.println("1. Bật đèn");
                    System.out.println("2. Tắt đèn");
                    System.out.println("3. Bật quạt");
                    System.out.println("4. Tắt quạt");
                    System.out.println("5. Set nhiệt độ điều hòa");

                    int cmdChoice = sc.nextInt();

                    switch (cmdChoice) {
                        case 1:
                            remote.setCommand(slot, new LightOnCommand(light));
                            break;
                        case 2:
                            remote.setCommand(slot, new LightOffCommand(light));
                            break;
                        case 3:
                            remote.setCommand(slot, new FanOnCommand(fan));
                            break;
                        case 4:
                            remote.setCommand(slot, new FanOffCommand(fan));
                            break;
                        case 5:
                            System.out.print("Nhập nhiệt độ: ");
                            int temp = sc.nextInt();
                            remote.setCommand(slot, new ACSetTemperatureCommand(ac, temp));
                            break;
                    }
                    break;

                case 2:
                    System.out.print("Nhấn nút: ");
                    int press = sc.nextInt();
                    remote.pressButton(press);
                    break;

                case 3:
                    remote.pressUndo();
                    break;

                case 0:
                    return;
            }
        }
    }
}
