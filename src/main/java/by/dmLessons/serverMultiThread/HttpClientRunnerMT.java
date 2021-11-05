package by.dmLessons.serverMultiThread;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;

import static java.net.http.HttpRequest.BodyPublishers.ofFile;

public class HttpClientRunnerMT {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        var request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9000"))
                .header("content-type", "application/json")
                .POST(ofFile(Path.of("src","main", "resources", "firstTrying.json")))
                .build();

        var response1 = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        var response2 = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        var response3 = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response1.get().body());
        System.out.println(response2.get().body());
        System.out.println(response3.get().body());
    }
}
