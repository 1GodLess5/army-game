package cz.godless.game;

import cz.godless.army.Army;
import cz.godless.army.Soldier;

public class Attack {
    // TODO continue here, should make special offense method
    private static int isOnCooldown = 0;
    public static void attackAgainstDefense(Army attackaresArmy, Army deffendersArmy, String attacker, String defender, boolean isSuper){
        int attackPower = calculatePower(attackaresArmy, "OFFENSIVE");
        int defendPower = calculatePower(deffendersArmy, "DEFENSIVE");
        int randomNumber;
        int totalDamage = 0;
        int[] defaultStrongerAttackRange = {5, 10};
        int[] defaultWeakerAttackRange = {1, 5};

        if (isSuper && isOnCooldown == 0 && attackPower > defendPower){
            defaultStrongerAttackRange[0] += 10;
            defaultStrongerAttackRange[1] += 20;
            isOnCooldown = 3;
        } else if (isSuper && isOnCooldown == 0 && attackPower < defendPower) {
            defaultWeakerAttackRange[0] += 9;
            defaultWeakerAttackRange[1] += 15;
            isOnCooldown = 3;
        }
        if (!isSuper && isOnCooldown != 0){
            isOnCooldown -= 1;
        }

        if (attackPower > defendPower){
            for (Soldier soldier : deffendersArmy.getSoldiers()){
                randomNumber = getRandom(defaultStrongerAttackRange[0], defaultStrongerAttackRange[1]);
                soldier.setHp(randomNumber);
                totalDamage += randomNumber;
            }
        } else {
            for (Soldier soldier : deffendersArmy.getSoldiers()){
                randomNumber = getRandom(defaultWeakerAttackRange[0], defaultWeakerAttackRange[1]);
                soldier.setHp(randomNumber);
                totalDamage += randomNumber;
            }
        }

        System.out.println("---ATTACK REPORT---");
        System.out.println("Commander's " + attacker + " army attacked " + defender + "army and dealt: ");
        System.out.println("TOTAL DAMAGE OF: " + totalDamage + " hp");
    }

    private static int calculatePower(Army armyToCalculate, String whatToCalculate){
        int power = 0;
        for (Soldier soldier : armyToCalculate.getSoldiers()){
            if (soldier.getName().getType().equals(whatToCalculate)){
                power += 5;
            } else if (soldier.getName().getType().equals("ADAPTABLE")) {
                power += 2;
            } else {
                power += 1;
            }
        }
        return power;
    }

    private static int getRandom(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static int getIsOnCooldown() {
        return isOnCooldown;
    }
}
