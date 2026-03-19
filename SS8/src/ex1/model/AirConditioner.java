package ex1.model;

public class AirConditioner implements Device{

    @Override
    public void turnON() {
        System.out.println("Điều hoà: Bật");
    }

    @Override
    public void turnOff() {
        System.out.println("Điều hoà: Tắt");
    }
}
