package ex1.factory;

import ex1.model.Device;
import ex1.model.Light;

public class LightFactory extends DeviceFactory{
    @Override
    public Device createDevice() {
        System.out.println("LightFactory: Đã tạo đèn mới");
        return new Light();
    }
}
