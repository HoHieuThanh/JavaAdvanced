import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void sum() {
    }

    @Test
    @DisplayName("Case 1")
    void sum1(){
        Main main = new Main();
        // Giá trị mong muốn
        Assertions.assertEquals(3, main.sum(1,2));
        Assertions.assertEquals(0, main.sum(1,3));
    }
}