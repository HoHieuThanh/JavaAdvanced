package cinema;

public class MainEx3 {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 5);
        TicketPool roomB = new TicketPool("B", 5);

        Thread counter1 = new Thread(
                new BookingCounter("Quay 1", roomA, roomB));

        Thread counter2 = new Thread(
                new BookingCounter("Quay 2", roomA, roomB));

        Thread supplier = new Thread(
                new TicketSupplier(roomA, roomB));

        counter1.start();
        counter2.start();
        supplier.start();
    }
}
