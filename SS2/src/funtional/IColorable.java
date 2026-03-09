package funtional;

public interface IColorable {
    String RED = "abcxyz";
    void printColor(String color);

    // Java 8
    // Phương thức mặc định
    default void draw(){}; // ko bắt buộc con phải ghi đè

    static void erase(){ // thuộc về interface (Chỉ I mới chấm đến)
        System.out.println("Xoá");
    }

    private void toStr(){ // chỉ truy cập trong I

    }
}
