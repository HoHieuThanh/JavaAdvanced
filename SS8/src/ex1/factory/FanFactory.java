package ex1.factory;

import ex1.model.Device;
import ex1.model.Fan;

public class FanFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("FanFactory: Đã tạo quạt mới.");
        return new Fan();
    }
}
