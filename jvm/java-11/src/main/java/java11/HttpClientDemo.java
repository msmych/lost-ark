package java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static java.net.http.HttpClient.newHttpClient;
import static support.PrintSupport.print;

public class HttpClientDemo {

    /**
     * Before running this code,
     * run the following command from <code>resources</code> directory:<br>
     * <br>
     * <code>ruby -run -ehttpd . -p8080</code>
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        var client = newHttpClient();

        var request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/web/index.html"))
            .header("Content-Type", "text/html")
            .GET()
            .build();

        var response = client.send(request, BodyHandlers.ofString());
        print("response headers", response.headers());
        print("HTML response", response.body());

        request = HttpRequest.newBuilder(URI.create("http://localhost:8080/web/data.json"))
            .header("Content-Type", "application/json")
            .GET()
            .build();
        client.sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(json -> print("JSON response", json))
            .join();
    }
}
