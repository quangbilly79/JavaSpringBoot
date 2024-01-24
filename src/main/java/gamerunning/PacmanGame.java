package gamerunning;

public class PacmanGame implements GamingConsole {

    @Override
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
