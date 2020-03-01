package advisor;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        Authenticator authenticator = Authenticator.getInstance();

        while (true) {
            input = scanner.next();
                if (authenticator.isAuthorized()) {
                    switch (input) {
                        case "new":
                            new Client().requestNew();
//                            System.out.println("---NEW RELEASES---\n" +
//                                    "Mountains [Sia, Diplo, Labrinth]\n" +
//                                    "Runaway [Lil Peep]\n" +
//                                    "The Greatest Show [Panic! At The Disco]\n" +
//                                    "All Out Life [Slipknot]");
                            break;
                        case "featured":
                            System.out.println("---FEATURED---\n" +
                                    "Mellow Morning\n" +
                                    "Wake Up and Smell the Coffee\n" +
                                    "Monday Motivation\n" +
                                    "Songs to Sing in the Shower");
                            break;
                        case "categories":
                            System.out.println("---CATEGORIES---\n" +
                                    "Top Lists\n" +
                                    "Pop\n" +
                                    "Mood\n" +
                                    "Latin");
                            break;
                        case "playlists":
                            System.out.println("--" + scanner.next().toUpperCase() + " PLAYLISTS---\n" +
                                    "Walk Like A Badass  \n" +
                                    "Rage Beats  \n" +
                                    "Arab Mood Booster  \n" +
                                    "Sunday Stroll");
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
