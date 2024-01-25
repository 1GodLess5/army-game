package cz.godless;

import cz.godless.army.Army;
import cz.godless.army.Soldier;
import cz.godless.game.StartGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        List<String> playersNames = StartGame.greetPlayers();
        Army userOneArmy = new Army(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        userOneArmy = userOneArmy.createArmy(playersNames.get(0), scanner);

        userOneArmy.reportArmy();

    }
}
