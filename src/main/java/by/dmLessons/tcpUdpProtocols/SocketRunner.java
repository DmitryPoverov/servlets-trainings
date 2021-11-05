package by.dmLessons.tcpUdpProtocols;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;

public class SocketRunner {
    public static void main(String[] args) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        var inetAddress = Inet4Address.getByName("google.com");  // вернет случайный из iPv4
        // Inet4Address.getAllByName()                                      // вернет массив адресов iPv4
        System.out.println("InetAddress = " + inetAddress + "\n");

        // Номер порта для подключению по протоколу tcp:
        // для http  - 80 port
        // для https - 443 port

        try (Socket socket = new Socket(inetAddress, 80);
             var outputStream = new DataOutputStream(socket.getOutputStream());   // чтобы отправить запрос на сервер
             var inputStream = new DataInputStream(socket.getInputStream())) {    // чтобы считать ответ с сервера

            outputStream.writeUTF("Hello-hello.");
            var response = inputStream.readAllBytes();
            for (byte b : response) {
                stringBuilder.append((char) b);
            }
            System.out.println(stringBuilder);
        }
    }
}
