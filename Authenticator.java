package advisor;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

class Authenticator {
    private static Authenticator instance;
    private Server server;
    private Client client;

    private Authenticator() {
        server = Server.getInstance();
        client = new Client();
        server.start();
    }

    void newSession() {
        String authUrl = "https://accounts.spotify.com/en/authorize?client_id=941ca8e7d13d404f97789c3416d47e5f&redirect_uri=http:%2F%2Flocalhost:8765&response_type=code";
        System.out.println(authUrl);
        server.start();
        System.out.println();
    }

    static Authenticator getInstance() {
        if (instance == null) {
            instance = new Authenticator();
        }
        return instance;
    }

    String getToken() {
        return null;
    }
}
