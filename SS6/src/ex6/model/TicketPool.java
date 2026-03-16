package ex6.model;
import java.util.*;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();
    private int counter = 0;

    public TicketPool(String roomName, int totalTickets) {

        this.roomName = roomName;

        addTickets(totalTickets);
    }

    public synchronized Ticket sellTicket() {

        while (true) {

            for (Ticket t : tickets) {

                if (!t.isSold()) {
                    t.setSold(true);
                    return t;
                }
            }

            try {

                System.out.println(Thread.currentThread().getName()
                        + " cho ve phong " + roomName);

                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {

            counter++;

            String id = roomName + "-" +
                    String.format("%03d", counter);

            tickets.add(new Ticket(id, roomName, 250000));
        }

        notifyAll();
    }

    public int getSoldCount() {

        int count = 0;

        for (Ticket t : tickets) {
            if (t.isSold()) count++;
        }

        return count;
    }

    public int getTotalTickets() {
        return tickets.size();
    }

    public String getRoomName() {
        return roomName;
    }
}

