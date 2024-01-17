package gamerunning;


// Class main để khởi tạo và chạy các thứ

import gamerunningspring.GameRunnerSpring;
import gamerunningspring.MarioGameSpring;

public class AppGamingBasic {

    public static void main(String[] args) {
        // Tạo 1 instance game Mario, sử dụng GamingConsole interface
        GamingConsole game = new MarioGameSpring();

        // Tạo 1 instance game Contra, sử dụng GamingConsole interface
        // Object Creation
        GamingConsole game1 = new ContraGame();

        // Tạo 1 instance game Runnner để chạy game Contra bên trên
        // Depedency Wiring, game1 là dependency của gamerunner1
        GameRunnerSpring gameRunner1 = new GameRunnerSpring(game1);

        // Tạo 1 instance game Runnner để chạy game Mario bên trên
        // Depedency Wiring, game là dependency của gamerunner
        GameRunnerSpring gameRunner = new GameRunnerSpring(game);
        // Tùy vào game mario hay contra mà chạy method tg ứng
        gameRunner.run();
    }

}
