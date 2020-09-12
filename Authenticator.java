package advisor;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

class Authenticator {
    private static Authenticator instance;
    Server server;
    private boolean isAuthorized;
    private String accessToken;

    private Authenticator() {
        server = Server.getInstance();
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    void newSession() {
        String spotifyURL = Main.access + "/en/authorize?";
        String client_id = "941ca8e7d13d404f97789c3416d47e5f";
        String redirect_uri = "http://127.0.0.1:" + server.getPort();

        String authUrl = spotifyURL + "client_id=" + client_id + "&redirect_uri=" + redirect_uri + "&response_type=code";
        System.out.println(authUrl);
        System.out.println("waiting for code...");
    }

    static Authenticator getInstance() {
        if (instance == null) {
            instance = new Authenticator();
        }
        return instance;
    }

    String getAccessToken() {
        return accessToken;
    }
}
