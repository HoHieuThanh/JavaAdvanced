package ex5;

import ex1.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("alexander", "a@gmail.com", "I"),
                new User("charlotte", "b@gmail.com", "U"),
                new User("Benjamin", "c@gmail.com", "I"),
                new User("tom", "d@gmail.com", "I"),
                new User("anna", "e@gmail.com", "U")
        );

        users.stream()
                .sorted(Comparator.comparingInt((User u) -> u.name().length()).reversed())
                .limit(3)
                .forEach(u -> System.out.println(u.name()));
    }
}

