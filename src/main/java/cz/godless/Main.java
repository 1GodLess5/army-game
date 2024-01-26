package cz.godless;

import cz.godless.army.Army;
import cz.godless.army.Soldier;
import cz.godless.game.Attack;
import cz.godless.game.StartGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        List<String> playersNames = StartGame.greetPlayers();
        Army userOneArmy = new Army(new ArrayList<>());
        userOneArmy = userOneArmy.createArmy(playersNames.get(0), scanner);
        Army userTwoArmy = new Army(new ArrayList<>());
        userTwoArmy = userTwoArmy.createArmy(playersNames.get(1), scanner);
        userOneArmy.reportArmy();
        userTwoArmy.reportArmy();
        Attack.attackAgainstDefense(userOneArmy, userTwoArmy, playersNames.get(0), playersNames.get(1));
        userTwoArmy.reportArmy();

    }
}
