package cz.godless.army;

import java.util.List;

public class Army {
    private List<Archer> archers;
    private List<Infantry> infantry;
    private List<Cavalry> cavalry;
    private List<Spearman> spearmen;

    public Army(List<Archer> archers, List<Infantry> infantry, List<Cavalry> cavalry, List<Spearman> spearmen) {
        this.archers = archers;
        this.infantry = infantry;
        this.cavalry = cavalry;
        this.spearmen = spearmen;
    }

}
