package gamerunningspring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingSpringConfigurationClass {
    //@Bean
    public GamingConsoleSpring getGameMario() {
        return new MarioGameSpring();
    }

}
