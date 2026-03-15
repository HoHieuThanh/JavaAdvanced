package cinema;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();
    private int ticketCounter = 0;

    public TicketPool(String roomName, int initial) {

        this.roomName = roomName;

        addTickets(initial);
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
                        + ": Het ve phong "
                        + roomName + ", dang cho...");

                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {

            ticketCounter++;

            String id = roomName + "-"
                    + String.format("%03d", ticketCounter);

            tickets.add(new Ticket(id, roomName));
        }

        System.out.println("Nha cung cap: Da them "
                + count + " ve vao phong " + roomName);

        notifyAll();
    }

    public String getRoomName() {
        return roomName;
    }
}
