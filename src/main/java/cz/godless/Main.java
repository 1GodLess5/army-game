package cz.godless;

import cz.godless.army.Army;
import cz.godless.army.Soldier;
import cz.godless.game.Attack;
import cz.godless.game.StartGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        // initialize players names
        List<String> playersNames = StartGame.greetPlayers();
        Army userOneArmy = new Army(new ArrayList<>(), playersNames.get(0));
        userOneArmy = userOneArmy.createArmy(scanner);
        Army userTwoArmy = new Army(new ArrayList<>(), playersNames.get(1));
        userTwoArmy = userTwoArmy.createArmy(scanner);
        userOneArmy.reportArmy();
        userTwoArmy.reportArmy();
        Attack.attackAgainstDefense(userOneArmy, userTwoArmy, true);
        userTwoArmy.reportArmy();

        // TODO continue here
        // TODO everything should be prepared to start making the game loop
    }
}
