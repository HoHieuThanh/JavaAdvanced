package ex5.devide;

public class Light {

    private boolean isOn = true;

    public void off() {
        isOn = false;
        System.out.println("Đèn: Tắt");
    }

    public void status() {
        System.out.println("Đèn: " + (isOn ? "Bật" : "Tắt"));
    }
}

