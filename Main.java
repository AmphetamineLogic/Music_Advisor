package advisor;

import java.awt.geom.RectangularShape;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static String access;
    static String resource;

    public static void main(String[] args) {
        access = "https://accounts.spotify.com";
        resource = "https://accounts.spotify.com/api";

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if ("-access".equals(args[i])) {
                    access = args[i+1];
                }
                if ("-resource".equals(args[i])) {
                    resource = args[i+1];
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        String input;
        Authenticator authenticator = Authenticator.getInstance();

        while (true) {
            input = scanner.next();
                if (authenticator.isAuthorized()) {
                    switch (input) {
                        case "new":
                            PrintData.printNewAlbums(new Client().request("new"));
                            break;
                        case "featured":
                            PrintData.printPlaylists(new Client().request("featured"));
                            break;
                        case "categories":
                            PrintData.printCategories(new Client().request("categories"));
                            break;
                        case "playlists":
                            PrintData.printPlaylists(new Client().request("playlists", scanner.next()));
                            break;
                        case "exit":
                            System.out.println("---GOODBYE!---");
                            exit(0);
                        }
            }
                else {
                    switch (input) {
                        case "auth":
                            authenticator.newSession();
                            break;
                        case "exit":
                            System.out.println("---GOODBYE!---");
                            exit(0);
                        default:
                            System.out.println("Please, provide access for application.");
                    }
                }
        }
    }
}
