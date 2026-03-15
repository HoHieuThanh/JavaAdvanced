package btth;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread shop1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (RepositoryTicket.totalTicket > 0){
                    RepositoryTicket.sellTicket();
                    System.out.println("Quầy 1 bán được 1 vé, còn lại " + RepositoryTicket.totalTicket);
                    count++;
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Số lượng vé Quầy 1 bán được là: " + count);
            }
        });
        Thread shop2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (RepositoryTicket.totalTicket > 0){
                    RepositoryTicket.sellTicket();
                    System.out.println("Quầy 2 bán được 1 vé, còn lại " + RepositoryTicket.totalTicket);
                    count++;
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Số lượng vé Quầy 2 bán được là: " + count);
            }
        });
        Thread shop3 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (RepositoryTicket.totalTicket > 0){
                    RepositoryTicket.sellTicket();
                    System.out.println("Quầy 3 bán được 1 vé, còn lại " + RepositoryTicket.totalTicket);
                    count++;
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Số lượng vé Quầy 3 bán được là: " + count);
            }
        });
        shop1.start();
        shop2.start();
        shop3.start();
    }
}
