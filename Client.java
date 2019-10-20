package advisor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;

class Client {
    private String uri;

    Client() {
        uri = "https://accounts.spotify.com/api/token";
    }

    void post(String code) throws Exception {
        String client_id = "941ca8e7d13d404f97789c3416d47e5f";
        String client_secret = "cd5b07f02d6c435981a5936e1cb5f15e";
        String body = "grant_type=authorization_code"
                + "&code=" + code
                + "&redirect_uri=http%3A%2F%2Flocalhost:8765"
                + "&client_id=" + client_id
                + "&client_secret=" + client_secret;

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<?> response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
