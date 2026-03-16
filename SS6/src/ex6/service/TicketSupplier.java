package ex6.service;

import ex6.model.TicketPool;

import java.util.List;

public class TicketSupplier implements Runnable {

    private List<TicketPool> rooms;

    public TicketSupplier(List<TicketPool> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                break;
            }

            for (TicketPool room : rooms) {

                room.addTickets(3);

                System.out.println("Supplier them 3 ve vao phong "
                        + room.getRoomName());
            }
        }
    }
}
