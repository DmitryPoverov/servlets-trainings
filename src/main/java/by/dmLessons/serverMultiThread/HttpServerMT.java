package by.dmLessons.serverMultiThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerMT {

    private final ExecutorService pool;
    private final int port;
    private boolean stopped;        // не инициализируем, т.к. все поля класса, которые булевы инициализированы false.

    public HttpServerMT(int port, int poolSize) {
        this.port = port;
        this.pool = Executors.newFixedThreadPool(poolSize);
    }
    
    public void run() {
        try {
            var server = new ServerSocket(port);
            while (!stopped) {
                var socket = server.accept();
                System.out.println("Socket accepted");
                pool.submit(() -> processSocket(socket));      // результат важен
                //pool.execute(() -> processSocket(socket));   // если результат не важен, тогда используем его
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket;                    // возможность уже созданный объект в try с ресурсами появилась после java 1.8
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {
// 1 шаг: обработка запроса (handle request).
            System.out.println("Request " + new String(inputStream.readNBytes(400)));
            Thread.sleep(10000);

// 2 шаг: формирование ответа на основании запроса. Здесь будет простой ответ: всем одно и тоже.
            var body = Files.readAllBytes(Path.of("src","main", "resources", "htmlTrying.html"));
            var headers = """
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body.length).getBytes();
            outputStream.write(headers);
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write(body);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
