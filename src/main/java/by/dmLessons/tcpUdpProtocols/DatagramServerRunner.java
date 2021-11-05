package by.dmLessons.tcpUdpProtocols;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServerRunner {
    public static void main(String[] args) throws IOException {

        try (var datagramServer = new DatagramSocket(7777)) {
            byte[] buffer = new byte[512];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            datagramServer.receive(packet);
            
            int counter = 0;            // этот огород для удаления null элементов массива байтов
            for(byte b : buffer) {
                if (b != 0) {
                    counter++;
                }
            }
            byte[] buffer2 = new byte[counter];
            for(int i=0; i<counter; i++) {
                buffer2[i] = buffer[i];
            }
            System.out.println(new String(buffer2));
        }
    }
}
