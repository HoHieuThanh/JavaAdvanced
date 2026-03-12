package ex6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService service;
    User existingUser;
    List<User> users;

    @BeforeEach
    void setUp() {

        service = new UserService();

        existingUser =
                new User("user@gmail.com",
                        LocalDate.of(2000,1,1));

        users = new ArrayList<>();
        users.add(existingUser);
    }

    @Test
    void updateProfile_success_whenEmailAndBirthDateValid() {

        UserProfile newProfile =
                new UserProfile("new@gmail.com",
                        LocalDate.of(1999,5,5));

        User result =
                service.updateProfile(existingUser,newProfile,users);

        assertNotNull(result);
    }

    @Test
    void updateProfile_fail_whenBirthDateInFuture() {

        UserProfile newProfile =
                new UserProfile("new@gmail.com",
                        LocalDate.now().plusDays(1));

        User result =
                service.updateProfile(existingUser,newProfile,users);

        assertNull(result);
    }

    @Test
    void updateProfile_fail_whenEmailDuplicated() {

        users.add(new User("dup@gmail.com",
                LocalDate.of(1998,1,1)));

        UserProfile newProfile =
                new UserProfile("dup@gmail.com",
                        LocalDate.of(1999,1,1));

        User result =
                service.updateProfile(existingUser,newProfile,users);

        assertNull(result);
    }

    @Test
    void updateProfile_success_whenEmailNotChanged() {

        UserProfile newProfile =
                new UserProfile("user@gmail.com",
                        LocalDate.of(1995,5,5));

        User result =
                service.updateProfile(existingUser,newProfile,users);

        assertNotNull(result);
    }

    @Test
    void updateProfile_success_whenUserListEmpty() {

        List<User> emptyUsers = new ArrayList<>();

        UserProfile newProfile =
                new UserProfile("abc@gmail.com",
                        LocalDate.of(1998,1,1));

        User result =
                service.updateProfile(existingUser,newProfile,emptyUsers);

        assertNotNull(result);
    }

    @Test
    void updateProfile_fail_whenDuplicateEmailAndFutureBirthDate() {

        users.add(new User("dup@gmail.com",
                LocalDate.of(1998,1,1)));

        UserProfile newProfile =
                new UserProfile("dup@gmail.com",
                        LocalDate.now().plusDays(2));

        User result =
                service.updateProfile(existingUser,newProfile,users);

        assertNull(result);
    }
}
