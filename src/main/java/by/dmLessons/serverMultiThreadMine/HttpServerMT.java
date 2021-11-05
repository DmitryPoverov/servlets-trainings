package by.dmLessons.serverMultiThreadMine;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerMT {

    private final ExecutorService pool;
    private final int port;
    private boolean stopped;

    public HttpServerMT(int port, int poolSize) {
        this.port = port;
        this.pool = Executors.newFixedThreadPool(poolSize);
    }
    
    public void run() {
        try {
            var server = new ServerSocket(port);
            while (!stopped) {
                var socket = server.accept();
                System.out.println("A method accept() has worked...");
                pool.submit(() -> processSocket(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket;
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {
// 1 обработка запроса.
            System.out.println("Request " + new String(inputStream.readNBytes(400)));
            Thread.sleep(5000);

// 2 шаг: формирование ответа из запроса.
            byte[] body = "An answer of the server".getBytes();
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
