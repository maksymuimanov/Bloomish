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
        itemsToAdd.forEach(itemToAdd -> this.addToTab(event, creativeModeTab, itemToAdd));
    }

    private void addToTab(
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
