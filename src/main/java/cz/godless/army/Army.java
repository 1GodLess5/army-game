package cz.godless.army;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Army {
    private int coins = 100;
    private List<Soldier> soldiers;
    private String playerName;
    private int isOnCooldown = 0;

    public Army(List<Soldier> soldiers, String playerName) {
        this.soldiers = soldiers;
        this.playerName = playerName;
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Army createArmy(Scanner scanner) {
        Army usersArmy = new Army(new ArrayList<>(), this.playerName);

        System.out.println("Commander " + this.playerName + " its time to create your army!");
        System.out.println();
        System.out.print("1) ");
        SoldierType.INFANTRY.getInformation();
        System.out.print("2) ");
        SoldierType.ARCHER.getInformation();
        System.out.print("3) ");
        SoldierType.CAVALRY.getInformation();
        System.out.print("4) ");
        SoldierType.SPEARMAN.getInformation();

        while (this.coins > 0) {
            while (true) {
                System.out.println("You have " + this.coins + " coins to spend.");
                System.out.println("Which soldier type would you like to purchase?");
                try {
                    int inputSoldier = scanner.nextInt();
                    if (inputSoldier < 1 || inputSoldier > 4) {
                        System.out.println("Invalid input.");
                        continue;
                    }
                    while (true) {

                        SoldierType soldier;
                        switch (inputSoldier) {
                            case 1 -> soldier = SoldierType.INFANTRY;
                            case 2 -> soldier = SoldierType.ARCHER;
                            case 3 -> soldier = SoldierType.CAVALRY;
                            case 4 -> soldier = SoldierType.SPEARMAN;
                            default -> {
                                return usersArmy;
                            }
                        }
                        if (soldier.getCost() > this.coins){
                            System.out.println("Not enough coins.");
                            break;
                        }

                        System.out.println("How many " + soldier.getName() + " would you like to purchase?");
                        try {
                            int howMany = scanner.nextInt();
                            if (howMany * soldier.getCost() > this.coins || howMany < 1) {
                                System.out.println("Not enough coins.");
                                continue;
                            }
                            List<? extends Soldier> newSoldiers = createSoldiers(soldier, howMany);

                            usersArmy.getSoldiers().addAll(newSoldiers);

                            this.coins -= howMany * soldier.getCost();
                            System.out.println("You have successfully purchased " + howMany + " " + soldier.getName() + " for " + howMany * soldier.getCost() + " coins");
                            System.out.println();
                            break;
                        } catch (IllegalArgumentException exception) {
                            System.out.println("Invalid input");
                            scanner.next();
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            }
        }
        return usersArmy;
    }

    private static Soldier createSoldier(SoldierType name, int count) {
        switch (name) {
            case INFANTRY -> {
                return new Infantry(count);
            }
            case ARCHER -> {
                return new Archer(count);
            }
            case CAVALRY -> {
                return new Cavalry(count);
            }
            case SPEARMAN -> {
                return new Spearman(count);
            }
        }
        return null;
    }

    private List<? extends Soldier> createSoldiers(SoldierType name, int count) {
        List<Soldier> soldiers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            soldiers.add(createSoldier(name, i));
        }
        return soldiers;
    }

    public void reportArmy(){
        String soldierName = "INFANTRY";
        System.out.println("\n");
        System.out.println(this.playerName.toUpperCase() + "'s ARMY:");
        if (!this.soldiers.isEmpty()){
            System.out.println("-----");
            for (Soldier soldier : this.soldiers) {
                if (String.valueOf(soldier.getName()).equals(soldierName)) {
                    soldier.report();
                } else {
                    soldierName = String.valueOf(soldier.getName());
                    System.out.println("-----");
                    soldier.report();
                }
            }
            System.out.println("-----");
        }
    }

    public int getIsOnCooldown() {
        return this.isOnCooldown;
    }

    public void setIsOnCooldown(int isOnCooldown) {
        this.isOnCooldown = isOnCooldown;
    }
}
