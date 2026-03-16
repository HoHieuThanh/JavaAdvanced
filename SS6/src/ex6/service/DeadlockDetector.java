package ex6.service;
import java.lang.management.*;

public class DeadlockDetector implements Runnable {

    @Override
    public void run() {

        ThreadMXBean bean =
                ManagementFactory.getThreadMXBean();

        while (true) {

            long[] threadIds =
                    bean.findDeadlockedThreads();

            if (threadIds != null) {

                System.out.println("DEADLOCK DETECTED!");

                ThreadInfo[] infos =
                        bean.getThreadInfo(threadIds);

                for (ThreadInfo info : infos) {
                    System.out.println(info.getThreadName());
                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

