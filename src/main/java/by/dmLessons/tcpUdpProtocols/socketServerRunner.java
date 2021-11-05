package by.dmLessons.tcpUdpProtocols;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class socketServerRunner {
    public static void main(String[] args) throws IOException {

        try (var serverSocket = new ServerSocket(7777);   // создает подключение.
             var socket = serverSocket.accept();        // возвращает сокет и ждет подключения, работает с одним
                                                               // подключением за раз, т.к. операция блокирующая.
             var inputStream = new DataInputStream(socket.getInputStream());      // чтение запроса клиента на сервер.
             var outputStream = new DataOutputStream(socket.getOutputStream())) { // для отправки ответа с сервера.

            System.out.println("A client request: " + inputStream.readUTF());     // выводим то, что прислал клиент.
            outputStream.writeUTF("A message from the server.");              // пишем в ответ сервера сообщение.
        }
    }
}
