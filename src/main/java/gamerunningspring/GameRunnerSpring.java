package gamerunningspring;

import gamerunningspring.GamingConsoleSpring;

// Class chung để chạy các game tương ứng
public class GameRunnerSpring {
    private final GamingConsoleSpring game;

    // Constructor: Tạo game tg ứng, thay vì fix cứng vs Mario game thì dùng Gaming Console Interface
    public GameRunnerSpring(GamingConsoleSpring game) {
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
