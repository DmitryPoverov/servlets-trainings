package by.dmLessons.server;

public class HttpServerRunner {
    public static void main(String[] args) {

        var httpServer = new HttpServer(9000);
        httpServer.run();
    }
}
