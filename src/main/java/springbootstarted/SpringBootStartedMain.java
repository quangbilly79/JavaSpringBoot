package springbootstarted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotation @SpringBootApplication cho class chính khởi chạy
// Mặc định localhost:8080
@SpringBootApplication
public class SpringBootStartedMain {
    public static void main(String[] args) {
        // Khởi chạy Spring project vs SpringApplication.run(SpringBootApplication.class)
        SpringApplication.run(SpringBootStartedMain.class);
    }
}
