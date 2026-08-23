package io.bloomish.api.creative;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.CollectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.List;

@Injected
public class SimpleCreativeModeTabAdder implements CreativeModeTabAdder {
    @Override
    public void addToTab(
            BuildCreativeModeTabContentsEvent event,
            ResourceKey<CreativeModeTab> creativeModeTab,
            ItemLike item,
            ItemLike... items
    ) {
        List<ItemLike> itemsToAdd = CollectionUtils.listOf(item, items);
        this.addAllToTab(event, creativeModeTab, itemsToAdd);
    }

    @Override
    public void addAllToTab(
            BuildCreativeModeTabContentsEvent event,
            ResourceKey<CreativeModeTab> creativeModeTab,
            Iterable<ItemLike> items
    ) {
        items.forEach(itemToAdd -> this.addItemToTab(event, creativeModeTab, itemToAdd));
    }

    private void addItemToTab(
            BuildCreativeModeTabContentsEvent event,
            ResourceKey<CreativeModeTab> creativeModeTab,
            ItemLike item
    ) {
        try {
            if (event.getTabKey() == creativeModeTab) event.accept(item);
        } catch (Exception e) {
            throw new CreativeModeTabException("Adding to the %s gone wrong for %s".formatted(creativeModeTab, item), e);
        }
    }
}
