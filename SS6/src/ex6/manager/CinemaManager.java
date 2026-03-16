package ex6.manager;

import ex6.model.TicketPool;
import ex6.service.BookingCounter;
import ex6.service.DeadlockDetector;
import ex6.service.TicketSupplier;

import java.util.List;
import java.util.concurrent.*;

public class CinemaManager {

    private ExecutorService executor =
            Executors.newCachedThreadPool();

    public void startSimulation(List<TicketPool> rooms,
                                int counterCount) {

        for (int i = 1; i <= counterCount; i++) {

            executor.submit(
                    new BookingCounter("Quay " + i, rooms));
        }

        executor.submit(new TicketSupplier(rooms));

        executor.submit(new DeadlockDetector());
    }

    public void shutdown() {

        executor.shutdownNow();
    }
}
