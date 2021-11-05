package by.dmLessons.serverMultiThreadMine;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.net.http.HttpRequest.BodyPublishers.ofFile;

public class HttpClientRunnerMT {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        HttpClient httpClient = HttpClient.newBuilder()
                .build();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9000"))
                .header("content-type", "application/json")
                .POST(ofFile(Path.of("src","main", "resources", "firstTrying.json")))
                .build();

        CompletableFuture<HttpResponse<String>> resp1 = httpClient.sendAsync(req, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> resp2 = httpClient.sendAsync(req, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> resp3 = httpClient.sendAsync(req, HttpResponse.BodyHandlers.ofString());

        System.out.println(resp1.get().body());
        System.out.println(resp2.get().body());
        System.out.println(resp3.get().body());
    }
}
