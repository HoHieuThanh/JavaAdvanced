import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DemoTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void soNT() {
    }

    @Test
    void fibonanci() {
    }

    @Test
    @DisplayName("Số nhỏ hơn 2 không phải số nguyên tố")
    void testPrimeLessThan2(){
        assertFalse(Demo.soNT(0));
        assertTrue(Demo.soNT(2));
    }

    @Test
    @DisplayName("Kiểm tra số nguyên tố")
    void testIsPrime(){
        assertTrue(Demo.soNT(3));
        assertFalse(Demo.soNT(4));
    }

    @Test
    @DisplayName("Số thứ tự nhập vào phải lớn hơn 0")
    void testNthLess0(){
        assertEquals(-1, Demo.fibonanci(-1));
    }

    @Test
    @DisplayName("Kiểm tra kết quả")
    void testIsFibonacci(){
        assertEquals(1, Demo.fibonanci(1));
        assertEquals(1, Demo.fibonanci(2));
        assertEquals(2, Demo.fibonanci(3));
        assertEquals(3, Demo.fibonanci(4));
        assertEquals(5, Demo.fibonanci(5));


    }
}