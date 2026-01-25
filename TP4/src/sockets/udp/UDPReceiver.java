package sockets.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(1234)) { // Listen on port 1234
            byte[] buffer = new byte[1024];
            System.out.println("UDP Receiver started on port 1234...");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet); // Receive packet

                String message = new String(packet.getData(), 0, packet.getLength());
                String sender = packet.getAddress().getHostAddress();

                System.out.println("Received from " + sender + ": " + message);

                if ("exit".equalsIgnoreCase(message.trim()) || "bye".equalsIgnoreCase(message.trim())) {
                    System.out.println("Exiting receiver...");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
