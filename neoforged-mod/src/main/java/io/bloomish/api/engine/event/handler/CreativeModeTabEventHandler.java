package io.bloomish.api.engine.event.handler;

import io.bloomish.api.channel.BiQueueChannelBus;
import io.bloomish.api.channel.Channels;
import io.bloomish.api.creative.CreativeModeTabAdder;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Collection;

@Injected
@Handler(BuildCreativeModeTabContentsEvent.class)
public class CreativeModeTabEventHandler implements EventHandler {
    private final BiQueueChannelBus biQueueChannelBus;
    private final CreativeModeTabAdder tabAdder;

    public CreativeModeTabEventHandler(BiQueueChannelBus biQueueChannelBus, CreativeModeTabAdder tabAdder) {
        this.biQueueChannelBus = biQueueChannelBus;
        this.tabAdder = tabAdder;
    }


    @Override
    public void handle() {
        this.subscribeModEvent(BuildCreativeModeTabContentsEvent.class, event -> {
            this.biQueueChannelBus.<ResourceKey<CreativeModeTab>, Holder<Item>>receive(Channels.CREATIVE_MODE_TAB_EVENT_HANDLER_BI_CHANNEL)
                    .forEach(entry -> {
                        ResourceKey<CreativeModeTab> tab = entry.key();
                        Collection<Holder<Item>> items = entry.value();
                        this.tabAdder.addAllToTab(event, tab, items.stream()
                                .map(Holder::value)
                                .map(ItemLike.class::cast)
                                .toList());
                    });
        });
    }
}
