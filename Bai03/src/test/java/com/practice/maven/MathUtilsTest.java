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
        assertEquals(5, result, "Phép cộng sai ");
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

    @Test
    public void testFilePath() {
        // Cố tình dùng dấu gạch chéo ngược của Windows (\)
        String expectedPath = "data\\temp\\file.txt";
        String actualPath = "data" + java.io.File.separator + "temp" + java.io.File.separator + "file.txt";

        System.out.println("Testing path on: " + System.getProperty("os.name"));
        // Bài test này sẽ CHỈ CHẠY ĐÚNG TRÊN WINDOWS
        // Trên Linux và macOS, nó sẽ báo lỗi vì chúng dùng dấu /
        assertEquals(expectedPath, actualPath, "Đường dẫn không tương thích hệ điều hành!");
    }

}
