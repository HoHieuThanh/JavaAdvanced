package ex6.service;

import ex6.model.Ticket;
import ex6.model.TicketPool;

import java.util.*;

public class BookingCounter implements Runnable {

    private String counterName;
    private List<TicketPool> rooms;
    private boolean running = true;

    public BookingCounter(String name, List<TicketPool> rooms) {
        this.counterName = name;
        this.rooms = rooms;
    }

    public void stopCounter() {
        running = false;
    }

    @Override
    public void run() {

        Random random = new Random();

        while (running) {

            TicketPool room =
                    rooms.get(random.nextInt(rooms.size()));

            Ticket ticket = room.sellTicket();

            System.out.println(counterName +
                    " ban ve " + ticket.getTicketId());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
