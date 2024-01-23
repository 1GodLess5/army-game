package cz.godless.Army;

public enum SoldierType {
    INFANTRY("Infantry", "Versatile units effective in most terrains.", "ADAPTABLE"),
    ARCHER("Archer", "Attack from a distance, effective in open spaces.", "OFFENSIVE"),
    CAVALRY("Cavalry", "Fast-moving units effective for flanking.", "OFFENSIVE"),
    SPEARMAN("Spearman", "Strong defensive unit.", "DEFENSIVE");

    private final String name;
    private final String description;
    private final String type;

    SoldierType(String name, String description, String type){
        this.name = name;
        this.description = description;
        this.type = type;
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
}
