package Core;

/**
 * ChronoRift oyunumuzun başlangıç noktasıdır
 * GameEngine'ı başlatır
 */

public class Main {
    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        engine.startGame();
    }
}
