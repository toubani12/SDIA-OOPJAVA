package sockets.game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class GameServer {
    // Shared magic number for the game session
    private static final int MAGIC_NUMBER = new Random().nextInt(101); // 0-100
    private static volatile boolean gameWon = false;

    public static void main(String[] args) {
        System.out.println("Server started. Magic Number is: " + MAGIC_NUMBER);
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            while (!gameWon) {
                System.out.println("Waiting for players...");
                Socket socket = serverSocket.accept(); // Accept connections
                // Multi-threaded handling
                new Thread(new PlayerHandler(socket, MAGIC_NUMBER)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Simple thread-safe method to signal game over
    public static synchronized void notifyWin() {
        gameWon = true;
    }

    public static boolean isGameWon() {
        return gameWon;
    }
}
