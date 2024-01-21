package cz.godless.biomes;

import java.util.List;

public abstract class Biome {
    private final String name;
    private final List<String> affectsBad;
    private final List<String> affectsWell;

    public Biome(String name, List<String> affectsBad, List<String> affectsWell) {
        this.name = name;
        this.affectsBad = affectsBad;
        this.affectsWell = affectsWell;
    }

    public String getName() {
        return name;
    }

    public List<String> getAffectsBad() {
        return affectsBad;
    }

    public List<String> getAffectsWell() {
        return affectsWell;
    }
}
