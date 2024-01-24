package cz.godless.game;

import cz.godless.army.Army;
import cz.godless.army.SoldierType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StartGame {
    private int coins;
    private String playerName;

    public StartGame(String playerName) {
        this.coins = 100;
        this.playerName = playerName;
    }

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

    private static String nameChoice(int playerCount, Scanner scanner){
        System.out.println("Commander " + playerCount + ", what is your name?");
        return scanner.nextLine();
    }

    public void createArmy(){
        System.out.println(this.playerName + " you have got " + this.coins + ".");
        System.out.print("1) ");
        SoldierType.INFANTRY.getInformation();
        System.out.print("2) ");
        SoldierType.ARCHER.getInformation();
        System.out.print("3) ");
        SoldierType.CAVALRY.getInformation();
        System.out.print("4) ");
        SoldierType.SPEARMAN.getInformation();

        while (this.coins > 0){

        }
    }
}
