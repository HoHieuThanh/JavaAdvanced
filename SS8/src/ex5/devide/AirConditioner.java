package ex5.devide;


import ex5.observer.Observer;

public class AirConditioner implements Observer {

    private int temperature = 25;

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Điều hòa: Nhiệt độ = " + temp);
    }

    @Override
    public void update(int temperature) {
        if (temperature > 30) {
            System.out.println("Điều hòa: Nhiệt độ = " + this.temperature + " (giữ nguyên)");
        }
    }

    public void status() {
        System.out.println("Điều hòa: " + temperature);
    }
}

