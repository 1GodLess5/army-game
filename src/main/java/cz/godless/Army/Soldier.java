package cz.godless.Army;

import java.util.List;

public abstract class Soldier {
    private int hp;
    private SoldierType type;

    public Soldier(int hp, SoldierType type){
        this.hp = hp;
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public SoldierType getType() {
        return type;
    }

    public static void report(List<Soldier> soldiers){
        int i = 0;

        for (Soldier soldier : soldiers){
            i++;
            System.out.println("Soldier " + soldier.getType() + " " + i + " here with " + soldier.getHp() + " hp.");
        }
    }

    public abstract void attack();

    public abstract void defend();

    public abstract void useSpecial();
}
