package cz.godless.army;

public abstract class Soldier {
    private int hp;
    private SoldierType type;
    private int soldierCount;

    public Soldier(SoldierType type, int soldierCount){
        this.hp = 100;
        this.type = type;
        this.soldierCount = soldierCount;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int damagedFor) {
        this.hp -= damagedFor;
    }

    public SoldierType getType() {
        return type;
    }

    public int getSoldierCount() {
        return soldierCount;
    }

    public void report() {
        System.out.println("Soldier " + this.getType() + " " + this.getSoldierCount() + " is here with " + this.getHp() + " hp.");
    }
}
