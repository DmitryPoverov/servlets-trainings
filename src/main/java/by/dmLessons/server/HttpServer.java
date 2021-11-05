package by.dmLessons.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpServer {

    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }
    
    public void run() {
        try {
            var server = new ServerSocket(port);
            var socket = server.accept();
            processSocket(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket;        // возможность помещать уже созданный объект в ресурсы появилась после java 1.8
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {
// 1ый шаг: обработка запроса. Здесь проста выводим его на печать.
            System.out.println("Request " + new String(inputStream.readNBytes(400)));
// 2ой шаг: формирование ответа.
            var body = Files.readAllBytes(Path.of("src","main", "resources", "htmlTrying.html"));
            var headers = """
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body.length).getBytes();
            outputStream.write(headers);
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
