package cinema;

public class MainEx2 {

    public static void main(String[] args) throws InterruptedException {

        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);

        BookingCounter counter1 =
                new BookingCounter("Quay 1", roomA, roomB);

        BookingCounter counter2 =
                new BookingCounter("Quay 2", roomA, roomB);

        TicketSupplier supplier =
                new TicketSupplier(roomA, roomB,
                        3, 3000, 2);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(supplier);

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(15000);

        System.out.println("\nKet thuc chuong trinh");

        System.out.println("Quay 1 ban duoc: "
                + counter1.getSoldCount());

        System.out.println("Quay 2 ban duoc: "
                + counter2.getSoldCount());

        System.out.println("Ve con lai phong A: "
                + roomA.getRemainingTickets());

        System.out.println("Ve con lai phong B: "
                + roomB.getRemainingTickets());

        System.exit(0);
    }
}
