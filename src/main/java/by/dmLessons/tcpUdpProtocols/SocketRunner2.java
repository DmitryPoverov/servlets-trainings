package by.dmLessons.tcpUdpProtocols;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner2 {
    public static void main(String[] args) throws IOException {

        var inetAddress = Inet4Address.getByName("localhost");

        try (var socket = new Socket(inetAddress, 7777);                   // подключение по адресу и порту

             var outputStream = new DataOutputStream(socket.getOutputStream()); // для отправки запроса на сервер
             var inputStream = new DataInputStream(socket.getInputStream());    // для чтения ответа с сервера
             var scanner = new Scanner(System.in)) {

            while (scanner.hasNextLine()) {
                var request = scanner.nextLine();
                outputStream.writeUTF(request);                         // вкладываем в запрос на сервер
                System.out.println("Server: " + inputStream.readUTF()); // печатаем ответ сервера
            }
        }
    }
}
