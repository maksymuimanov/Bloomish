package io.bloomish.api.engine.event.handler;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.KeyedQueueChannelBus;
import io.bloomish.api.creative.CreativeModeTabAdder;
import io.bloomish.api.engine.event.subscriber.ModEventBusSubscriber;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.HolderUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Queue;

@Injected
public class CreativeModeTabEventHandler extends AbstractEventHandler<BuildCreativeModeTabContentsEvent> {
    private final KeyedQueueChannelBus channelBus;
    private final CreativeModeTabAdder tabAdder;

    public CreativeModeTabEventHandler(ModEventBusSubscriber eventBusSubscriber, KeyedQueueChannelBus channelBus, CreativeModeTabAdder tabAdder) {
        super(eventBusSubscriber);
        this.channelBus = channelBus;
        this.tabAdder = tabAdder;
    }

    @Override
    protected void handle(BuildCreativeModeTabContentsEvent event) {
        this.channelBus.<ResourceKey<CreativeModeTab>, Holder<Item>>forEach(DataChannels.CREATIVE_MODE_TAB_EVENT_HANDLER,
                (tab, items) ->
                        this.addItemsToCreativeTab(event, tab, items));
    }

    private void addItemsToCreativeTab(BuildCreativeModeTabContentsEvent event, ResourceKey<CreativeModeTab> tab, Queue<Holder<Item>> items) {
        this.tabAdder.addAllToTab(event, tab, HolderUtils.unwrapToList(items));
    }
}
