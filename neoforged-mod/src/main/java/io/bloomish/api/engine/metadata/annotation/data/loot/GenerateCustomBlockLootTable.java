package io.bloomish.api.engine.metadata.annotation.data.loot;

import io.bloomish.api.engine.event.data.loot.LootProviderStrategy;
import io.bloomish.api.engine.event.data.loot.spec.CustomBlockLootTableSpec;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateCustomBlockLootTable {
    Class<? extends LootProviderStrategy<CustomBlockLootTableSpec>> strategy();
    String[] additionalData() default {};
}