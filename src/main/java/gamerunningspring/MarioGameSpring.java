package gamerunningspring;

import gamerunningspring.GamingConsoleSpring;

// Game Mario implement GamingConsole
public class MarioGameSpring implements GamingConsoleSpring {

    // Các method di chuyển
    public void up() {
        System.out.println("Jumping up");
    }
    public void down() {
        System.out.println("Get into the hole");
    }
    public void left() {
        System.out.println("Slow down");
    }
    public void right() {
        System.out.println("Accelerate");
    }
}
