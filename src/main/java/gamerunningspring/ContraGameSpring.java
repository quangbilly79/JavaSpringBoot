package gamerunningspring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Thêm @Component để k cần khai báo @Bean
// Thêm @Primary để ưu tiên trong TH nhiều @Component cùng Class cha
@Component
@Primary
public class ContraGameSpring implements GamingConsoleSpring {
    // Các method di chuyển
    public void up() {
        System.out.println("up Contra");
    }
    public void down() {
        System.out.println("down hole Contra");
    }
    public void left() {
        System.out.println("Slow down Contra");
    }
    public void right() {
        System.out.println("Accelerate Contra");
    }
}
