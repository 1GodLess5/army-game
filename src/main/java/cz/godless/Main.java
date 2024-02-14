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
        boolean gameEnd = false;
        int[] playersTurn = {0, 1};

        List<String> playersNames = StartGame.greetPlayers();

        List<Army> armies = new ArrayList<>();
        Army userOneArmy = new Army(new ArrayList<>(), playersNames.get(0));
        userOneArmy = userOneArmy.createArmy(scanner);
        armies.add(userOneArmy);
        Army userTwoArmy = new Army(new ArrayList<>(), playersNames.get(1));
        userTwoArmy = userTwoArmy.createArmy(scanner);
        armies.add(userTwoArmy);

        while (!gameEnd){
            mainMenu(playersNames.get(playersTurn[0]), armies.get(playersTurn[0]), armies.get(playersTurn[1]));

            gameEnd = checkWinner(armies);
            if (playersTurn[0] == 0) {
                playersTurn[0] = 1;
                playersTurn[1] = 0;
            } else {
                playersTurn[0] = 0;
                playersTurn[1] = 1;
            }
        }
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

    public static boolean checkWinner(List<Army> armies){
        int armiesCount = 0;
        int hpCount = 0;

        while (armiesCount < 2){
            for (Soldier soldier : armies.get(armiesCount).getSoldiers()){
                if (soldier.getHp() > 0){
                    hpCount++;
                }
            }

            if (hpCount == 0){
                System.out.println("\n\n\n");
                System.out.println("Commander " + armies.get(armiesCount).getPlayerName() + "'s army is dead.");
                if (armiesCount == 0){
                    System.out.println("COMMANDER " + armies.get(1).getPlayerName().toUpperCase() + " WINS.");


                } else {
                    System.out.println("COMMANDER " + armies.get(0).getPlayerName().toUpperCase() + " WINS.");
                }
                System.out.println("\nCommanders, thanks for playing my game.");
                return true;
            }
            armiesCount ++;
            hpCount = 0;
        }
        return false;
    }
}
