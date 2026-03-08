package ex4;

import java.io.IOException;

public class Main {

    // Method C
    public static void saveToFile() throws IOException {
        throw new IOException("Lỗi khi ghi dữ liệu vào file!");
    }

    // Method B
    public static void processUserData() throws IOException {
        saveToFile();
    }

    // Method A
    public static void main(String[] args) {

        try {

            processUserData();

        } catch (IOException e) {

            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }

        System.out.println("Chương trình tiếp tục chạy...");
    }
}

