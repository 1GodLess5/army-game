package cz.godless.game;

import cz.godless.army.Army;
import cz.godless.army.Soldier;

public class Attack {
    private final Army attackersArmy;
    private final Army deffendersArmy;

    public Attack(Army attackersArmy, Army deffendersArmy) {
        this.attackersArmy = attackersArmy;
        this.deffendersArmy = deffendersArmy;
    }

    private int attackPower(){
        int attack = 0;
        for (Soldier soldier : this.attackersArmy.getSoldiers()){
            if (soldier.getName().getType().equals("OFFENSIVE")){
                attack += 5;
            } else if (soldier.getName().getType().equals("ADAPTABLE")) {
                attack += 2;
            } else {
                attack += 1;
            }
        }
        return attack;
    }

    private int defendPower(){
        int defend = 0;
        for (Soldier soldier : this.deffendersArmy.getSoldiers()){

            if (soldier.getName().getType().equals("OFFENSIVE")){
                defend += 5;
            } else if (soldier.getName().getType().equals("ADAPTABLE")) {
                defend += 2;
            } else {
                defend += 1;
            }
        }
        return defend;
    }

    private int getRandom(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

}
