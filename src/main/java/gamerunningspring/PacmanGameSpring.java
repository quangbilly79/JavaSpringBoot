package gamerunningspring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PacmanGameSpring")
public class PacmanGameSpring implements GamingConsoleSpring {
    public void up() {
        System.out.println("up Pacman");
    }

    @Override
    public void down() {
        System.out.println("down Pacman");
    }

    @Override
    public void left() {
        System.out.println("left Pacman");
    }

    @Override
    public void right() {
        System.out.println("right Pacman");
    }

}
