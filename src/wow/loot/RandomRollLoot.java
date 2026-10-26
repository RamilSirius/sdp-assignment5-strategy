package wow.loot;

import java.util.List;
import java.util.Random;

public class RandomRollLoot implements LootStrategy {
    private static final int MAX_ROLL = 100;

    private final Random dice = new Random();

    @Override
    public String chooseWinner(List<String> party) {
        String winner = party.get(0);
        int bestRoll = 0;

        for (String player : party) {
            int roll = dice.nextInt(MAX_ROLL) + 1;
            System.out.println("  " + player + " rolls " + roll);
            if (roll > bestRoll) {
                bestRoll = roll;
                winner = player;
            }
        }
        return winner;
    }
}
