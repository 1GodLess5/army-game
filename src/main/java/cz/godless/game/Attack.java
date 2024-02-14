package cz.godless.game;
import cz.godless.army.Army;
import cz.godless.army.Soldier;

public class Attack {
    public static void attack(Army attackersArmy, Army deffendersArmy, boolean isSuper){
        int attackPower = calculatePower(attackersArmy, "OFFENSIVE");
        int defendPower = calculatePower(deffendersArmy, "DEFENSIVE");
        int randomNumber;
        int totalDamage = 0;
        int[] defaultStrongerAttackRange = {5, 10};
        int[] defaultWeakerAttackRange = {1, 5};

        if (isSuper && attackersArmy.getIsOnCooldown() == 0) {
            if (attackPower > defendPower) {
                defaultStrongerAttackRange[0] += 10;
                defaultStrongerAttackRange[1] += 20;
            } else {
                defaultWeakerAttackRange[0] += 9;
                defaultWeakerAttackRange[1] += 15;
            }
            attackersArmy.setIsOnCooldown(3);
        }
        if (!isSuper && attackersArmy.getIsOnCooldown() != 0){
            int cooldown = attackersArmy.getIsOnCooldown() - 1;
            attackersArmy.setIsOnCooldown(cooldown);
        }

        if (attackPower > defendPower){
            for (Soldier soldier : deffendersArmy.getSoldiers()){
                if (!(soldier.getHp() <= 0)){
                    randomNumber = getRandom(defaultStrongerAttackRange[0], defaultStrongerAttackRange[1]);
                    soldier.setHp(randomNumber);
                    totalDamage += randomNumber;
                }
            }
        } else {
            for (Soldier soldier : deffendersArmy.getSoldiers()){
                if (!(soldier.getHp() <= 0)) {
                    randomNumber = getRandom(defaultWeakerAttackRange[0], defaultWeakerAttackRange[1]);
                    soldier.setHp(randomNumber);
                    totalDamage += randomNumber;
                }
            }
        }

        System.out.println("---ATTACK REPORT---");
        System.out.println("Commander's " + attackersArmy.getPlayerName() + " army attacked " + deffendersArmy.getPlayerName() + "'s army and dealt: ");
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
