package ex2;
import ex2.facade.SmartHomeFacade;
import ex2.sensor.OldThermometer;
import ex2.sensor.TemperatureSensor;
import ex2.sensor.ThermometerAdapter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TemperatureSensor sensor = new ThermometerAdapter(new OldThermometer());
        SmartHomeFacade facade = new SmartHomeFacade(sensor);

        while (true) {
            System.out.println("""
                    
                    ===== SMART HOME =====
                    1. Xem nhiệt độ
                    2. Rời nhà
                    3. Chế độ ngủ
                    4. Thoát
                    """);

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    facade.getCurrentTemperature();
                    break;

                case 2:
                    facade.leaveHome();
                    break;

                case 3:
                    facade.sleepMode();
                    break;

                case 4:
                    System.out.println("Thoát chương trình");
                    return;
            }
        }
    }
}
