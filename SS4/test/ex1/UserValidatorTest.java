package ex1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    UserValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidator();
    }

    @AfterEach
    void tearDown() {
        validator = null;
    }

    @Test
    void TC01() {
        // Arrange
        String username = "user123";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertTrue(result);
    }

    @Test
    void TC02(){
        // Arrange
        String username = "abc";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }

    @Test
    void TC03(){
        // Arrange
        String username = "user name";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        assertFalse(result);
    }
}
