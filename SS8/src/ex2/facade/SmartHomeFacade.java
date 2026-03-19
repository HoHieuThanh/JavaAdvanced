package ex2.facade;

import ex2.device.AirConditioner;
import ex2.device.Fan;
import ex2.device.Light;
import ex2.sensor.TemperatureSensor;

public class SmartHomeFacade {
    private Light light = new Light();
    private Fan fan = new Fan();
    private AirConditioner ac = new AirConditioner();

    private TemperatureSensor sensor;

    public SmartHomeFacade(TemperatureSensor sensor) {
        this.sensor = sensor;
    }

    public void leaveHome() {
        light.off();
        fan.off();
        ac.off();
    }

    public void sleepMode() {
        light.off();
        ac.setTemperature(28);
        fan.lowSpeed();
    }

    public void getCurrentTemperature() {
        double temp = sensor.getTemperatureCelsius();
        System.out.printf("Nhiệt độ hiện tại: %.1f°C\n", temp);
    }
}
