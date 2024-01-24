package gamerunningspring;

import gamerunningspring.GamingConsoleSpring;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


// Game Mario implement GamingConsole
// Thêm component thay vì tạo Bean để getInstance
@Component
@Qualifier("MarioGameSpring")
public class MarioGameSpring implements GamingConsoleSpring {

    // Các method di chuyển
    public void up() {
        System.out.println("Jumping up Mario");
    }
    public void down() {
        System.out.println("Get into the hole Mario");
    }
    public void left() {
        System.out.println("Slow down Mario");
    }
    public void right() {
        System.out.println("Accelerate Mario");
    }
}
