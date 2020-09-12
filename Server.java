package advisor;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

class Server {
    private static Server instance;
    private int port;
    private HttpServer httpServer;
    private String accessCode;

    private Server() {
        port = (int) (8000 + Math.random() * (9000 - 8000));
//        port = 8765;
        Handler handler = new Handler();
        try {
            httpServer = HttpServer.create();
            httpServer.bind(new InetSocketAddress(port), 0);
            httpServer.createContext("/", handler);
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void shutdown() {
        httpServer.stop(0);
    }

    String getAccessCode() {
        return accessCode;
    }

    static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    int getPort() {
        return this.port;
    }

    class Handler implements HttpHandler {
        public void handle (HttpExchange httpExchange) throws IOException {
            String hello = " ";
            httpExchange.sendResponseHeaders(200, hello.length());
//            httpExchange.sendResponseHeaders(200, 0);
            httpExchange.getResponseBody().write(hello.getBytes());
            accessCode = httpExchange.getRequestURI().getQuery().split("code=")[1];
            System.out.println("code received");
            System.out.println("Making http request for access_token...");
            try {
                new Client().requestAccessToken(accessCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            httpExchange.getResponseBody().close();
        }
    }
}
