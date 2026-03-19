package ex1.singleton;

public class HardwareConnection {
    private static HardwareConnection instance;
    private HardwareConnection(){}
    public static HardwareConnection getInstance(){
        if (instance == null){
            instance = new HardwareConnection();
            System.out.println("HardwareConnection: Đã kết nối phần cứng");
        }
        return instance;
    }

    public void connect(){}
    public void disconnect(){}
}
