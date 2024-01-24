package gamerunningspring;

import gamerunningspring.GamingConsoleSpring;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Class chung để chạy các game tương ứng
// Thêm @Component thay vì tạo Bean để getInstance
@Component
public class GameRunnerSpring {
    private final GamingConsoleSpring game;

    // Constructor: Tạo game tg ứng, thay vì fix cứng vs Mario game thì dùng Gaming Console Interface
    // Thêm @Qualifier để ưu tiên trong TH nhiều @Component cùng Class cha
    public GameRunnerSpring(@Qualifier("MarioGameSpring") GamingConsoleSpring game) {
        this.game = game;
    }

    // Khởi chạy các method tg ứng
    // Giờ dùng game để gọi
    public void run() {
        game.up();
        game.down();
        game.left();
        game.right();
        System.out.println("Running game: " + game);
    }
}
