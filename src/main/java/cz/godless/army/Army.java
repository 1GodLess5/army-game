package cz.godless.army;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Army {
    private int coins = 100;
    private List<Archer> archers;
    private List<Infantry> infantry;
    private List<Cavalry> cavalry;
    private List<Spearman> spearmen;

    public Army(List<Archer> archers, List<Infantry> infantry, List<Cavalry> cavalry, List<Spearman> spearmen) {
        this.archers = archers != null ? archers : List.of();
        this.infantry = infantry != null ? infantry : List.of();;
        this.cavalry = cavalry != null ? cavalry : List.of();;
        this.spearmen = spearmen != null ? spearmen : List.of();;
    }

    public List<Archer> getArchers() {
        return archers;
    }

    public List<Infantry> getInfantry() {
        return infantry;
    }

    public List<Cavalry> getCavalry() {
        return cavalry;
    }

    public List<Spearman> getSpearmen() {
        return spearmen;
    }

    public Army createArmy(String playerName, Scanner scanner) {
        Army usersArmy = new Army(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        System.out.println("Commander " + playerName + " its time to create your army!");
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
            System.out.println("You have " + this.coins + " coins to spend.");
            System.out.println("Which soldier type would you like to purchase?");
            while (true) {
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

                        System.out.println("How many " + soldier.getName() + " would you like to purchase?");
                        try {
                            int howMany = scanner.nextInt();
                            if (howMany * soldier.getCost() > this.coins) {
                                System.out.println("Not enough coins.");
                                continue;
                            }
                            List<? extends Soldier> newSoldiers = createSoldiers(soldier, howMany);
                            switch (soldier) {
                                case INFANTRY -> usersArmy.getInfantry().addAll((List<Infantry>) newSoldiers);
                                case ARCHER -> usersArmy.getArchers().addAll((List<Archer>) newSoldiers);
                                case CAVALRY -> usersArmy.getCavalry().addAll((List<Cavalry>) newSoldiers);
                                case SPEARMAN -> usersArmy.getSpearmen().addAll((List<Spearman>) newSoldiers);
                            }
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
        System.out.println("\n");
        reportSoldierList(this.infantry);
        reportSoldierList(this.archers);
        reportSoldierList(this.cavalry);
        reportSoldierList(this.spearmen);
        System.out.println("-----");
    }

    private void reportSoldierList(List<? extends Soldier> soldiers){
        if (!soldiers.isEmpty()){
            System.out.println("-----");
            for (Soldier soldier : soldiers) {
                soldier.report();
            }
        }
    }
}
