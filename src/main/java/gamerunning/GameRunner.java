package gamerunning;

// Class chung để chạy các game tương ứng
public class GameRunner {
    private final MarioGame marioGame;

    // Constructor: Tạo game tg ứng (mario game)
    public GameRunner(MarioGame marioGame) {
        this.marioGame = marioGame;
    }

    // Khởi chạy các method tg ứng trong Mario game
    public void run() {
        marioGame.up();
        marioGame.down();
        marioGame.left();
        marioGame.right();
        System.out.println("Running game: " + marioGame);
    }
}
