package ex3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserProcessorTest {
    UserProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new UserProcessor();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testValidEmailFormat() {

        String result = processor.processEmail("user@gmail.com");

        assertEquals("user@gmail.com", result);
    }

    @Test
    void testEmailMissingAtSymbol() {

        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail("usergmail.com");
        });
    }

    @Test
    void testEmailMissingDomain() {

        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail("user@");
        });
    }

    @Test
    void testEmailNormalizationToLowerCase() {

        String result = processor.processEmail("Example@Gmail.com");

        assertEquals("example@gmail.com", result);
    }
}
