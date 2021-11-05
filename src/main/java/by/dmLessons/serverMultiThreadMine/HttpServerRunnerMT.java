package by.dmLessons.serverMultiThreadMine;

public class HttpServerRunnerMT {
    public static void main(String[] args) {

        var httpServer = new HttpServerMT(9000, 100);
        httpServer.run();
    }
}
