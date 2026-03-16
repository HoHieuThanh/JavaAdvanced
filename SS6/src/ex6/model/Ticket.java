package ex6.model;
public class Ticket {

    private String ticketId;
    private String roomName;
    private boolean sold;
    private double price;

    public Ticket(String ticketId, String roomName, double price) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.price = price;
        this.sold = false;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getRoomName() {
        return roomName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
