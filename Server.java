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
    private boolean isStarted;
    private String accessCode;

    private Server() {
        port = 8765;
        Handler handler = new Handler();
        try {
            httpServer = HttpServer.create();
            httpServer.bind(new InetSocketAddress(port), 0);
            httpServer.createContext("/", handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void start() {
        if (!isStarted) {
            httpServer.start();
            isStarted = true;
        }
    }

    void shutdown() {
        httpServer.stop(100);
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

    class Handler implements HttpHandler {
        public void handle (HttpExchange httpExchange) throws IOException {
            String hello = "hello, world";
            httpExchange.sendResponseHeaders(200, hello.length());
            httpExchange.getResponseBody().write(hello.getBytes());
            accessCode = httpExchange.getRequestURI().getQuery().split("code=")[1];
            System.out.println(accessCode);
            try {
                new Client().post(accessCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            httpExchange.getResponseBody().close();
        }
    }
}
