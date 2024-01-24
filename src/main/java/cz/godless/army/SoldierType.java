package cz.godless.army;

public enum SoldierType {
    INFANTRY("Infantry", "Versatile units effective in most terrains.", "ADAPTABLE", 5),
    ARCHER("Archer", "Attack from a distance, effective in open spaces.", "OFFENSIVE", 10),
    CAVALRY("Cavalry", "Fast-moving units effective for flanking.", "OFFENSIVE", 5),
    SPEARMAN("Spearman", "Strong defensive unit.", "DEFENSIVE", 10);

    private final String name;
    private final String description;
    private final String type;
    private final int cost;

    SoldierType(String name, String description, String type, int cost){
        this.name = name;
        this.description = description;
        this.type = type;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public void getInformation(){
        System.out.println(this.getName() + ": " + this.getDescription() + " => Costs: " + this.getCost() + " coins.");
    }
}
