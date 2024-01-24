package gamerunningspring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("gamerunningspring")
public class GamingSpringConfigurationClass {
    // Tạo Bean method lấy trực tiếp interface GameConsole
//    @Bean
//    public GamingConsoleSpring getGame() {
//        return new MarioGameSpring();
//    }

    // Tạo Bean methtod lấy class GameRunner,
    // tham số đầu vào là game (interface GameConsole) bên trên
//    @Bean
//    public GameRunnerSpring getGameRunner(GamingConsoleSpring game) {
//        return new GameRunnerSpring(game);
//    }

    // Thay vi` tao. Bean, co' the? them
    // @Component vao` dau` class can` tao. Bean,
    // @ComponentScan("package.path") vao` dau` config class
}
