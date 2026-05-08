package com.practice.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {

    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    // Hàm cộng hai số
    public int add(int a, int b) {
        logger.info("Đang tính cộng: {} + {}", a, b);
                return a + b;
    }


    public double divide(int a, int b) {
        if (b == 0) {
            logger.error("Lỗi: Không được chia cho số 0!");
            throw new IllegalArgumentException("Không thể chia cho 0");
        }
        logger.debug("Đang tính chia: {} / {}", a, b);
        return (double) a / b;
    }

    public static void main(String[] args) {
        logger.info("Chương trình MathUtils đã khởi động");
        MathUtils math = new MathUtils();

        System.out.println("Kết quả cộng: " + math.add(10, 5));

        try {
            math.divide(10, 0);
        } catch (Exception e) {

        }
    }
}
