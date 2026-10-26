package wow.loot;

import java.util.List;

public class MasterLooterLoot implements LootStrategy {
    private final String masterLooter;

    public MasterLooterLoot(String masterLooter) {
        this.masterLooter = masterLooter;
    }

    @Override
    public String chooseWinner(List<String> party) {
        return masterLooter;
    }
}
