package gamerunning;


// Class main để khởi tạo và chạy các thứ

public class App01GamingBasic {
    public static void main(String[] args) {
        // Tạo 1 instance game Mario vs Interface GamingConsole
        GamingConsole gameMario = new MarioGame();

        // Tạo 1 instance game Contra vs Interface GamingConsole
        GamingConsole gameContra = new ContraGame();

        // Tạo 1 instance game Pacman vs Interface GamingConsole
        GamingConsole gamePacman = new PacmanGame();

        // Tạo 1 instance game Runnner để chạy game bên trên
        // Tùy vào game là contra hay mario mà chạy các hàm tg ứng
        // Wiring dependency, gamePacman la` dep cua? gameRunner
        GameRunner gameRunner = new GameRunner(gamePacman);

        // Gọi method run
        gameRunner.run();
    }

}
