package gamerunning;


// Class main để khởi tạo và chạy các thứ

public class AppGamingBasic {

    public static void main(String[] args) {
        // Tạo 1 instance game Mario, sử dụng GamingConsole interface
        GamingConsole game = new MarioGame();

        // Tạo 1 instance game Contra, sử dụng GamingConsole interface
        // Object Creation
        GamingConsole game1 = new ContraGame();

        // Tạo 1 instance game Runnner để chạy game Contra bên trên
        // Depedency Wiring, game1 là dependency của gamerunner1
        GameRunner gameRunner1 = new GameRunner(game1);

        // Tạo 1 instance game Runnner để chạy game Mario bên trên
        // Depedency Wiring, game là dependency của gamerunner
        GameRunner gameRunner = new GameRunner(game);
        // Tùy vào game mario hay contra mà chạy method tg ứng
        gameRunner.run();
    }

}
