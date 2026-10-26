package wow.loot;

import java.util.List;

public interface LootStrategy {
    String chooseWinner(List<String> party);
}
