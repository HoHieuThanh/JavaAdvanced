package ex2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService service = new UserService();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAge18_isValid() {
        int age = 18;
        boolean result = service.checkRegistrationAge(age);
        assertTrue(result);
    }

    @Test
    void testAge17_isInvalid() {
        int age = 17;
        boolean result = service.checkRegistrationAge(age);
        assertFalse(result);
    }

    @Test
    void testNegativeAge_throwException() {
        int age = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            service.checkRegistrationAge(age);
        });
    }
}