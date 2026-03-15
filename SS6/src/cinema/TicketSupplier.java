package cinema;

public class TicketSupplier implements Runnable {

    private TicketPool roomA;
    private TicketPool roomB;

    public TicketSupplier(TicketPool roomA, TicketPool roomB) {

        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {

        while (true) {

            try {

                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            roomA.addTickets(3);
            roomB.addTickets(3);
        }
    }
}
