package wow;

import wow.loot.LootStrategy;

import java.util.List;

public class LootDistributor {
    private final List<String> party;
    private LootStrategy lootStrategy;

    public LootDistributor(List<String> party, LootStrategy lootStrategy) {
        this.party = party;
        this.lootStrategy = lootStrategy;
    }

    public void setLootStrategy(LootStrategy lootStrategy) {
        this.lootStrategy = lootStrategy;
    }

    public void distribute(String item) {
        String winner = lootStrategy.chooseWinner(party);
        System.out.println(winner + " receives [" + item + "]");
    }
}
