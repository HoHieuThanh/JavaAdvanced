package btth;

public class RepositoryTicket {
    public static int totalTicket = 10;
    public synchronized static void sellTicket(){
        totalTicket--;
    }
}
