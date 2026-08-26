package io.bloomish.api.engine.event.data.server.modifier;

import java.util.List;

public record ChestModifierJson(
        String type,
        List<Condition> conditions,
        String item
) implements JsonSerializable {
    public ChestModifierJson(String type, String chestId, float chance, String item) {
        this(type, List.of(
                Condition.lootTableId(chestId),
                Condition.randomChance(chance)
        ), item);
    }

    public record Condition(
            String condition,
            String loot_table_id,
            Float chance
    ) implements JsonSerializable {
        private static final String NEOFORGE_LOOT_TABLE_ID = "neoforge:loot_table_id";
        private static final String MINECRAFT_RANDOM_CHANCE = "minecraft:random_chance";

        public static Condition lootTableId(String lootTableId) {
            return new Condition(NEOFORGE_LOOT_TABLE_ID, lootTableId, null);
        }

        public static Condition randomChance(float chance) {
            return new Condition(MINECRAFT_RANDOM_CHANCE, null, chance);
        }
    }
}
