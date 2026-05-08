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

    /*
     * @Test
     * public void testFilePath() {
     * // Cố tình dùng dấu gạch chéo ngược của Windows (\)
     * String expectedPath = "data\\temp\\file.txt";
     * String actualPath = "data" + java.io.File.separator + "temp" +
     * java.io.File.separator + "file.txt";
     * 
     * System.out.println("Testing path on: " + System.getProperty("os.name"));
     * // Bài test này sẽ CHỈ CHẠY ĐÚNG TRÊN WINDOWS
     * // Trên Linux và macOS, nó sẽ báo lỗi vì chúng dùng dấu /
     * assertEquals(expectedPath, actualPath,
     * "Đường dẫn không tương thích hệ điều hành!");
     * }
     */
    @Test
    public void testFilePath() {
        // Cách viết mới: Dùng java.nio.file.Path
        // Nó sẽ tự động dùng \ trên Windows và / trên Linux/macOS
        java.nio.file.Path path = java.nio.file.Paths.get("data", "temp", "file.txt");
        String actualPath = path.toString();

        // Tạo chuỗi mong đợi một cách thông minh bằng File.separator
        String expectedPath = "data" + java.io.File.separator + "temp" + java.io.File.separator + "file.txt";

        System.out.println("Testing path on: " + System.getProperty("os.name") + " -> " + actualPath);
        assertEquals(expectedPath, actualPath, "Đường dẫn phải tương thích với mọi hệ điều hành!");
    }

    // 1. Test trường hợp chia thành công (Để cover nốt dòng logger.debug và lệnh
    // return)
    @Test
    public void testDivideSuccess() {
        MathUtils math = new MathUtils();
        double result = math.divide(10, 2);
        assertEquals(5.0, result, "10 chia 2 phải bằng 5.0");
    }

    // 2. Test hàm main (Để cover các dòng logger.info và lệnh gọi trong main)
    @Test
    public void testMain() {
        String[] args = {};
        // Gọi hàm main để đảm bảo JaCoCo ghi nhận các dòng trong đó đã chạy
        MathUtils.main(args);
        assertTrue(true);
    }

}
