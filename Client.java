package advisor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

class Client {
    private Authenticator authenticator;
    private String apiPath;
    private String client_id;
    private String client_secret;
    private HttpClient client;
    private HttpRequest httpRequest;
    private HttpResponse<?> httpResponse;

    Client() {
        client = HttpClient.newBuilder().build();
        authenticator = Authenticator.getInstance();
    }

    void requestAccessToken(String code) throws Exception {
        apiPath = "https://accounts.spotify.com/api/token";
        client_id = "941ca8e7d13d404f97789c3416d47e5f";
        client_secret = "cd5b07f02d6c435981a5936e1cb5f15e";
        String body = "grant_type=authorization_code"
                + "&code=" + code
                + "&redirect_uri=http%3A%2F%2Flocalhost:8765"
                + "&client_id=" + client_id
                + "&client_secret=" + client_secret;


        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(apiPath))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        httpResponse = client.send(request, BodyHandlers.ofString());
        System.out.println("Success!");
//        System.out.println(response.body());
        authenticator.setAuthorized(true);
        setAccessToken(httpResponse.body().toString());
    }

    void setAccessToken (String response) {
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        String accessToken = jsonObject.get("access_token").getAsString();
        System.out.println(accessToken);
        authenticator.setAccessToken(accessToken);
    }

    String requestNew () {
        apiPath = "https://api.spotify.com/v1/browse/new-releases";
        httpRequest = HttpRequest.newBuilder()
                .header("Authorization", "Bearer " + Authenticator.getInstance().getAccessToken())
                .uri(URI.create(apiPath))
                .GET()
                .build();
        try {
            httpResponse = client.send(httpRequest, BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(httpResponse.body());
        return httpResponse.body().toString();
    }
}
