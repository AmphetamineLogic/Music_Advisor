package advisor;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

class Authenticator {
    private static Authenticator instance;
    private Server server;

    private Authenticator() {
        server = Server.getInstance();
        server.start();
    }

    void newSession() {
        server.start();
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
