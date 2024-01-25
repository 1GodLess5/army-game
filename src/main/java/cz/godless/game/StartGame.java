package cz.godless.game;

import cz.godless.army.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {

    public static List<String> greetPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Greetings, Commanders!");
        System.out.println("The battlefield awaits your leadership.");
        System.out.println("May your strategies be sharp, and your armies mighty.");
        System.out.println();
        System.out.println();

        List<String> players = new ArrayList<>();
        players.add(nameChoice(1, scanner));
        players.add(nameChoice(2, scanner));

        return players;
    }

    private static String nameChoice(int playerCount, Scanner scanner) {
        System.out.println("Commander " + playerCount + ", what is your name?");
        return scanner.nextLine();
    }
}
