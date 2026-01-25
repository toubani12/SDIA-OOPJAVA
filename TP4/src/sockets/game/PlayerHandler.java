package sockets.game;

import java.io.*;
import java.net.Socket;

public class PlayerHandler implements Runnable {
    private Socket socket;
    private int magicNumber;

    public PlayerHandler(Socket socket, int magicNumber) {
        this.socket = socket;
        this.magicNumber = magicNumber;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("Welcome! Guess the number between 0 and 100.");
            String inputLine;
            int attempts = 0;

            while ((inputLine = in.readLine()) != null && !GameServer.isGameWon()) {
                try {
                    int guess = Integer.parseInt(inputLine);
                    attempts++;

                    if (guess < magicNumber) {
                        out.println("TOO_LOW");
                    } else if (guess > magicNumber) {
                        out.println("TOO_HIGH");
                    } else {
                        out.println("CORRECT");
                        out.println("You won in " + attempts + " attempts!");
                        GameServer.notifyWin();
                        break;
                    }
                } catch (NumberFormatException e) {
                    out.println("Please enter a valid number.");
                }
            }
        } catch (IOException e) {
            System.out.println("Player disconnected.");
        } finally {
            try {
                if (socket != null && !socket.isClosed()) socket.close();
            } catch (IOException ignored) {}
        }
    }
}
