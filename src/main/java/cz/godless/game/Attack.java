package cz.godless.game;

import cz.godless.army.Army;
import cz.godless.army.Soldier;

public class Attack {

    public static void attackAgainstDefense(Army attackaresArmy, Army deffendersArmy, String attacker, String defender){
        int attackPower = calculatePower(attackaresArmy, "OFFENSIVE");
        int defendPower = calculatePower(deffendersArmy, "DEFENSIVE");
        int randomNumber;
        int totalDamage = 0;

        if (attackPower > defendPower){
            for (Soldier soldier : deffendersArmy.getSoldiers()){
                randomNumber = getRandom(5, 10);
                soldier.setHp(randomNumber);
                totalDamage += randomNumber;
            }
        } else {
            for (Soldier soldier : deffendersArmy.getSoldiers()){
                randomNumber = getRandom(1, 5);
                soldier.setHp(randomNumber);
                totalDamage += randomNumber;
            }
        }

        int index = 0;
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
}
