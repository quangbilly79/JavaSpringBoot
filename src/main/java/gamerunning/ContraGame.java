package gamerunning;

// Game Contra, implement GamingConsole
public class ContraGame implements GamingConsole {
    // Các method di chuyển
    public void up() {
        System.out.println("up");
    }
    public void down() {
        System.out.println("down hole");
    }
    public void left() {
        System.out.println("Slow down");
    }
    public void right() {
        System.out.println("Accelerate");
    }
}
