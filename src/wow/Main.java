package wow;

import wow.loot.MasterLooterLoot;
import wow.loot.RandomRollLoot;
import wow.loot.RoundRobinLoot;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> party = List.of("Ramil", "Thrall", "Jaina", "Sylvanas", "Arthas");
        LootDistributor loot = new LootDistributor(party, new RoundRobinLoot());

        System.out.println("== Loot method: Round Robin ==");
        loot.distribute("Cruel Barb");
        loot.distribute("Cookie's Tenderizer");
        loot.distribute("Smite's Mighty Hammer");

        System.out.println("\n== Loot method: Random Roll ==");
        loot.setLootStrategy(new RandomRollLoot());
        loot.distribute("Thunderfury, Blessed Blade of the Windseeker");

        System.out.println("\n== Loot method: Master Looter ==");
        loot.setLootStrategy(new MasterLooterLoot("Ramil"));
        loot.distribute("Ashbringer");
    }
}
