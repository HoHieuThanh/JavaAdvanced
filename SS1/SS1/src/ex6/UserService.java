package ex6;

import ex3.User;

import java.io.IOException;

public class UserService {

    public static void processUser(User user) throws IOException {

        FileService.saveToFile();
    }
}
