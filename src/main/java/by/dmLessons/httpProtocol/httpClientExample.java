package by.dmLessons.httpProtocol;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;

public class httpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {

        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .GET()
                .build();
        var response = httpClient.send(request, BodyHandlers.ofString());
        System.out.println(response.body());
        System.out.println(response.headers());

        System.out.println("-----------------------------------");

        HttpRequest request2 = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .POST(BodyPublishers.ofFile(Path.of("src", "main","java", "by", "dmLessons", "httpProtocol", "UrlExample.java")))
                .build();
        var response2 = httpClient.send(request, BodyHandlers.ofString());
        System.out.println(response2.body());
        System.out.println(response2.headers());

    }
}
