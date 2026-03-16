package ex6;

import ex6.manager.CinemaManager;
import ex6.model.TicketPool;
import ex6.service.StatisticsService;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<TicketPool> rooms = new ArrayList<>();
        CinemaManager manager = new CinemaManager();

        while (true) {

            System.out.println("""
                    =======================
                    1. Bắt đầu mô phỏng
                    2. Tạm dừng mô phỏng
                    3. Tiếp tục mô phỏng
                    4. Thêm vé vào phòng
                    5. Xem thống kê
                    6. Phát hiện deadlock
                    7. Thoát
                    ========================
                    Lựa chọn: """);

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("So phong: ");
                    int roomCount = sc.nextInt();

                    System.out.print("So ve/phong: ");
                    int ticketCount = sc.nextInt();

                    System.out.print("So quay: ");
                    int counters = sc.nextInt();

                    for (int i = 0; i < roomCount; i++) {

                        char name = (char) ('A' + i);

                        rooms.add(new TicketPool(
                                String.valueOf(name),
                                ticketCount));
                    }

                    manager.startSimulation(rooms, counters);

                    System.out.println("He thong da khoi dong");

                    break;

                case 4:

                    rooms.get(0).addTickets(3);

                    break;

                case 5:

                    StatisticsService.printStats(rooms);

                    break;

                case 7:

                    manager.shutdown();

                    System.out.println("Ket thuc chuong trinh");

                    return;
            }
        }
    }
}
