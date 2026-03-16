package ex6.service;

import ex6.model.TicketPool;

import java.util.*;

public class StatisticsService {

    public static void printStats(List<TicketPool> rooms) {

        System.out.println("=== THONG KE ===");

        double revenue = 0;

        for (TicketPool room : rooms) {

            int sold = room.getSoldCount();
            int total = room.getTotalTickets();

            revenue += sold * 250000;

            System.out.println("Phong "
                    + room.getRoomName()
                    + ": "
                    + sold + "/" + total + " ve");
        }

        System.out.println("Doanh thu: "
                + revenue + " VND");
    }
}
