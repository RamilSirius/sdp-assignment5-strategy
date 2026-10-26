# Assignment 5 — Strategy Pattern (World of Warcraft)

In WoW the party leader can change the **loot method** at any moment: Round Robin,
Random Roll or Master Looter. Each loot method is a separate algorithm that decides
who gets the item. `LootDistributor` doesn't know which one is active, it just asks
the current strategy:

```java
LootDistributor loot = new LootDistributor(party, new RoundRobinLoot());
loot.distribute("Cruel Barb");

loot.setLootStrategy(new MasterLooterLoot("Ramil"));   // switched at runtime
loot.distribute("Ashbringer");
```

## Structure

```
src/wow/
├── Main.java                  // Client: picks and configures the loot method
├── LootDistributor.java       // Context: holds a LootStrategy and delegates to it
└── loot/
    ├── LootStrategy.java      // Strategy interface: chooseWinner(party)
    ├── RoundRobinLoot.java    // Players get items in turn
    ├── RandomRollLoot.java    // Everyone rolls 1-100, highest roll wins
    └── MasterLooterLoot.java  // One chosen player gets everything
```

## Run

```bash
javac -d out $(find src -name "*.java")
java -cp out wow.Main
```

## Clean Code principles

1. **Polymorphism instead of conditionals** — there is no `if`/`switch` on the loot method
   anywhere. `LootDistributor.distribute` just calls `lootStrategy.chooseWinner(party)`.
2. **Meaningful names** — `RoundRobinLoot`, `RandomRollLoot`, `MasterLooterLoot`,
   `chooseWinner`, `setLootStrategy`. The name says what the algorithm does.
3. **Single Responsibility** — each strategy contains exactly one loot algorithm.
   The context only stores the party and the current strategy.
4. **Context is algorithm-agnostic** — `LootDistributor` depends only on the
   `LootStrategy` interface and never imports a concrete strategy.
5. **Open/Closed, easy extensibility** — a new method (for example Free For All) is one new
   class that implements `LootStrategy`. `LootDistributor` and the other strategies stay unchanged.
6. **No magic numbers** — the roll limit is the named constant `MAX_ROLL`.
