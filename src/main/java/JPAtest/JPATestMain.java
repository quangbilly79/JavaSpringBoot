package JPAtest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Tạo SpringBootApp class vs @SpringBootApplication (class chính khởi chạy)
@SpringBootApplication
public class JPATestMain {
    public static void main(String[] args) {
        System.out.println("SpringApplication run------------");
        // Chạy class tg ứng vs  SpringApplication.run(SpringMain.class, args)
        SpringApplication.run(JPATestMain.class, args);
    }
}
