package gamerunningspring;


// Class main để khởi tạo và chạy các thứ

import gamerunningspring.MarioGameSpring;
import gamerunningspring.GamingConsoleSpring;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("gamerunningspring")
public class AppGamingBasicSpring {
    public static void main(String[] args) {
        // Tạo context từ class config tg ứng (class chứa bean, có @Config... ở đầu)
        // Co' the? dung` class chua' main lam` class config
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppGamingBasicSpring.class);


        // Lấy game (interface GamingConsoleSpring) từ Bean tg ứng
        GamingConsoleSpring game = context.getBean(GamingConsoleSpring.class);
        game.up();
        // Lấy gameRunner (class GameRunnerSpring) từ Bean tg ứng
        GameRunnerSpring gameRunner = context.getBean(GameRunnerSpring.class);
        gameRunner.run();
    }

}
