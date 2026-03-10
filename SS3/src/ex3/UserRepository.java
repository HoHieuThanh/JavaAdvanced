package ex3;


import ex1.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> users = Arrays.asList(
            new User("alice", "alice@gmail.com", "ACTIVE"),
            new User("bob", "bob@yahoo.com", "INACTIVE"),
            new User("charlie", "charlie@gmail.com", "ACTIVE")
    );

    public Optional<User> findUserByUsername(String username) {

        return users.stream()
                .filter(u -> u.name().equalsIgnoreCase(username))
                .findFirst();
    }
}

