package ex4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordServiceTest {

    PasswordService service;

    @BeforeEach
    void setUp() {
        service = new PasswordService();
    }

    @Test
    void testPasswordStrengthCases() {

        assertAll(

                // TC01
                () -> assertEquals("Mạnh",
                        service.evaluatePasswordStrength("Abc123!@")),

                // TC02
                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("abc123!@")),

                // TC03
                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("ABC123!@")),

                // TC04
                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("Abcdef!@")),

                // TC05
                () -> assertEquals("Trung bình",
                        service.evaluatePasswordStrength("Abc12345")),

                // TC06
                () -> assertEquals("Yếu",
                        service.evaluatePasswordStrength("Ab1!")),

                // TC07
                () -> assertEquals("Yếu",
                        service.evaluatePasswordStrength("password")),

                // TC08
                () -> assertEquals("Yếu",
                        service.evaluatePasswordStrength("ABC12345"))
        );
    }
}
