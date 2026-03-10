package ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bài 1");
        List<User> userList = Arrays.asList(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE")
        );
        userList.forEach(System.out::println);

        System.out.println("\nBài 2");
        userList.stream().filter(user -> user.email().endsWith("gmail.com"))
                .forEach(System.out::println);

        System.out.println("\nBài 3");

    }
}
