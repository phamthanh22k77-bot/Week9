package com.practice.maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    // Một bài kiểm tra
    @Test
    public void testAdd() {
        MathUtils math = new MathUtils();
        int result = math.add(2, 3);

        // So sành
        assertEquals(2, result, "Phép cộng sai ");
    }

    // Bài kiểm tra bắt lỗi chia cho 0
    @Test
    public void testDivideByZero() {
        MathUtils math = new MathUtils();

        // Bắt lỗi
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            math.divide(10, 0);
        });
        assertEquals("Không thể chia cho 0", exception.getMessage());
    }
}
