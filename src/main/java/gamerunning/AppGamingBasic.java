package gamerunning;


// Class main để khởi tạo và chạy các thứ

public class AppGamingBasic {

    public static void main(String[] args) {
        // Tạo 1 instance game Mario
        MarioGame marioGame = new MarioGame();

        // Tạo 1 instance game Contra
        ContraGame contraGame = new ContraGame();
        // Tạo 1 instance game Runnner để chạy game Contra bên trên
        //GameRunner gameRunner1 = new GameRunner(contraGame); // Lỗi do phải thêm Constructor tg ứng

        // Tạo 1 instance game Runnner để chạy game Mario bên trên
        GameRunner gameRunner = new GameRunner(marioGame);
        // Gọi method run
        gameRunner.run();
    }

}
