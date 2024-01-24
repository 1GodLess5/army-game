package cz.godless.army;

import java.util.List;

public class Army {
    private List<Archer> archers;
    private List<Infantry> infantry;
    private List<Cavalry> cavalry;
    private List<Spearman> spearmen;

    public Army(List<Archer> archers, List<Infantry> infantry, List<Cavalry> cavalry, List<Spearman> spearmen) {
        this.archers = archers != null ? archers : List.of();
        this.infantry = infantry != null ? infantry : List.of();;
        this.cavalry = cavalry != null ? cavalry : List.of();;
        this.spearmen = spearmen != null ? spearmen : List.of();;
    }

}
