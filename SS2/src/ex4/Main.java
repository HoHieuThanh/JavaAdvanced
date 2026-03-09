package ex4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Alice"),
                new User("Bob"),
                new User("Charlie")
        );

        users.stream()
                .map(User::getUsername)
                .forEach(System.out::println);

        Supplier<User> supplier = User::new;

        User u = supplier.get();
        System.out.println(u.getUsername());
    }
}
