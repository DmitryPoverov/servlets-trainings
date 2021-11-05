package by.dmLessons.tcpUdpProtocols;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {

        var inetAddress = InetAddress.getByName("localhost");

        try (var datagramSocket = new DatagramSocket()) {
            var bytes = "A request from the UDP client.".getBytes();
            var packet = new DatagramPacket(bytes, bytes.length, inetAddress, 7777);
            datagramSocket.send(packet);
        }
    }
}
