package sockets.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSender {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress receiverAddress = InetAddress.getByName("localhost"); // Target IP
            int port = 1234;
            Scanner scanner = new Scanner(System.in);

            System.out.println("UDP Sender started. Type 'bye' to exit.");

            while (true) {
                System.out.print("Message: ");
                String message = scanner.nextLine(); // Read input

                byte[] data = message.getBytes();
                DatagramPacket packet = new DatagramPacket(data, data.length, receiverAddress, port);
                socket.send(packet); // Send packet

                if ("bye".equalsIgnoreCase(message)) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
