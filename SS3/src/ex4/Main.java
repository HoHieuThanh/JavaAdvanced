package ex4;

import ex1.User;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@gmail.com", "UNACTIVE"),
                new User("alice", "alice2@gmail.com", "ACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE")
        );

        List<User> uniqueUsers = new ArrayList<>(
                users.stream()
                        .collect(Collectors.toMap(
                                User::name,
                                u -> u,
                                (existing, replacement) -> existing
                        ))
                        .values()
        );

        uniqueUsers.forEach(System.out::println);
    }
}

