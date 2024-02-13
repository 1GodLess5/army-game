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
        // initialize both armies
        Army userOneArmy = new Army(new ArrayList<>(), playersNames.get(0));
        userOneArmy = userOneArmy.createArmy(scanner);
        Army userTwoArmy = new Army(new ArrayList<>(), playersNames.get(1));
        userTwoArmy = userTwoArmy.createArmy(scanner);
        List<Army> armies = new ArrayList<>();
        armies.add(userOneArmy);
        armies.add(userTwoArmy);

        userOneArmy.reportArmy();
        userTwoArmy.reportArmy();
        Attack.attack(userOneArmy, userTwoArmy, true);
        userTwoArmy.reportArmy();

        System.out.println(userOneArmy.getIsOnCooldown());
        System.out.println(userTwoArmy.getIsOnCooldown());


    }
    
    public static void mainMenu(String playersMenu, Army playersArmy, Army otherArmy) {
        boolean cooldown = true;
        int userDecision;
        System.out.println("-----");
        do {
            System.out.println(playersMenu.toUpperCase() + "'s turn");
            System.out.println("1 - Print My Army");
            System.out.println("2 - Attack");
            System.out.println("3 - Defend");
            if (playersArmy.getIsOnCooldown() == 0){
                System.out.println("4 - Use Super");
                cooldown = false;
            }
            System.out.println("Your choice: ");

            while (true){
                try {
                    userDecision = scanner.nextInt();
                    if (cooldown){
                        if (userDecision < 1 || userDecision > 3){
                            System.out.println("Invalid input.");
                            System.out.println("Try again.");
                            continue;
                        }
                    }else {
                        if (userDecision < 1 || userDecision >4){
                            System.out.println("Invalid input.");
                            System.out.println("Try again.");
                            continue;
                        }
                    }
                    break;
                } catch (Exception e){
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            }

            switch (userDecision){
                case 1 -> playersArmy.reportArmy();
                case 2 -> Attack.attack(playersArmy, otherArmy, false);
                case 3 -> Attack.attack(otherArmy, playersArmy, false);
                case 4 -> Attack.attack(playersArmy, otherArmy, true);
            }

        } while (userDecision == 1);
    }
}
