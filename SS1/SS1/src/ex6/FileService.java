package ex6;

import java.io.IOException;

public class FileService {

    public static void saveToFile() throws IOException {

        // giả lập lỗi ghi file
        throw new IOException("Không thể ghi dữ liệu vào file!");
    }
}
