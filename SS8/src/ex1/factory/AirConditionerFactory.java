package ex1.factory;

import ex1.model.AirConditioner;
import ex1.model.Device;

public class AirConditionerFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("AirConditionerFactory: Đã tạo điều hòa mới.");
        return new AirConditioner();
    }
}
