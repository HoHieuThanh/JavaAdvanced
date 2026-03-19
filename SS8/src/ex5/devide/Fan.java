package ex5.devide;

import ex5.observer.Observer;

public class Fan implements Observer {

    private String speed = "OFF";

    public void setSpeed(String speed) {
        this.speed = speed;
        System.out.println("Quạt: Chạy tốc độ " + speed);
    }

    @Override
    public void update(int temperature) {
        if (temperature > 30) {
            speed = "HIGH";
            System.out.println("Quạt: Nhiệt độ cao, chạy tốc độ mạnh");
        }
    }

    public void status() {
        System.out.println("Quạt: " + speed);
    }
}
