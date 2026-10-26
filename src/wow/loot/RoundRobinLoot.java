package wow.loot;

import java.util.List;

public class RoundRobinLoot implements LootStrategy {
    private int nextPlayerIndex = 0;

    @Override
    public String chooseWinner(List<String> party) {
        String winner = party.get(nextPlayerIndex % party.size());
        nextPlayerIndex++;
        return winner;
    }
}
