package sockets.game;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9999)) { // Connect to server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            // Read welcome message
            System.out.println("Server: " + in.readLine());

            String response;
            while (true) {
                System.out.print("Enter guess: "); // Prompt user
                String guess = scanner.nextLine();
                out.println(guess); // Send guess

                response = in.readLine();
                if (response == null) {
                    System.out.println("Server closed connection.");
                    break;
                }
                System.out.println("Server: " + response); // Display response

                if (response.startsWith("CORRECT")) {
                    String stats = in.readLine();
                    System.out.println(stats); // Show attempts
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
