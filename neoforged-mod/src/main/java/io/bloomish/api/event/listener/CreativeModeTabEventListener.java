package io.bloomish.api.event.listener;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.channel.ObserveObjectChannel;
import io.bloomish.api.event.creative.CreativeModeTabAdder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Queue;

@Bean
public class CreativeModeTabEventListener {
    private final Queue<CreativeModeTabItem> creativeModeTabItems;
    private final CreativeModeTabAdder tabAdder;

    public CreativeModeTabEventListener(
            @ObserveObjectChannel(value = "CreativeModeTabEventListener", returnType = ObserveObjectChannel.ReturnType.QUEUE) Queue<CreativeModeTabItem> creativeModeTabItems,
            CreativeModeTabAdder tabAdder
    ) {
        this.creativeModeTabItems = creativeModeTabItems;
        this.tabAdder = tabAdder;
    }

    @ListenEvent
    public void listen(BuildCreativeModeTabContentsEvent event) {
        this.creativeModeTabItems.forEach(creativeModeTabItem ->
                this.tabAdder.addToTab(event, creativeModeTabItem.tab(), creativeModeTabItem.item().value()));
    }

    public record CreativeModeTabItem(
            ResourceKey<CreativeModeTab> tab,
            Holder<Item> item
    ) {
    }
}
