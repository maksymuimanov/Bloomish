package io.bloomish.api.creative;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public interface CreativeModeTabAdder {
    void addToTab(
            BuildCreativeModeTabContentsEvent event,
            ResourceKey<CreativeModeTab> creativeModeTab,
            ItemLike item,
            ItemLike... items
    );
}
