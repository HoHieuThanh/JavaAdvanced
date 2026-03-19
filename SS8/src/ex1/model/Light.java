package ex1.model;

public class Light implements Device{

    @Override
    public void turnON() {
        System.out.println("Đèn: Bật");
    }

    @Override
    public void turnOff() {
        System.out.println("Đèn: Tắt");
    }
}
