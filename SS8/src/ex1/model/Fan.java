package ex1.model;

public class Fan implements Device{
    @Override
    public void turnON() {
        System.out.println("Quạt: Bật");
    }

    @Override
    public void turnOff() {
        System.out.println("Quạt: Tắt");
    }
}
