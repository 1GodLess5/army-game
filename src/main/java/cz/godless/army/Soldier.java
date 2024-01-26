package cz.godless.army;

public abstract class Soldier {
    private int hp;
    private SoldierType name;
    private int soldierCount;

    public Soldier(SoldierType name, int soldierCount){
        this.hp = 100;
        this.name = name;
        this.soldierCount = soldierCount;
    }

    public int getHp() {
        return hp;
    }

    public SoldierType getName() {
        return name;
    }

    public int getSoldierCount() {
        return soldierCount;
    }

    public void setHp(int minusHp){
        this.hp -= minusHp;
    }

    public void report() {
        System.out.println("Soldier " + this.getName() + " " + this.getSoldierCount() + " is here with " + this.getHp() + " hp.");
    }
}
