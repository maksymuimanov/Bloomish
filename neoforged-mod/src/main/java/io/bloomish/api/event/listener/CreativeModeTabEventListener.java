package io.bloomish.api.event.listener;

import io.bloomish.api.channel.deprecated.DataChannels;
import io.bloomish.api.channel.deprecated.KeyedQueueChannelBus;
import io.bloomish.api.event.creative.CreativeModeTabAdder;
import io.bloomish.api.util.HolderUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Queue;

@EventListener
public class CreativeModeTabEventListener {
    private final KeyedQueueChannelBus channelBus;
    private final CreativeModeTabAdder tabAdder;

    public CreativeModeTabEventListener(KeyedQueueChannelBus channelBus, CreativeModeTabAdder tabAdder) {
        this.channelBus = channelBus;
        this.tabAdder = tabAdder;
    }

    public void listen(BuildCreativeModeTabContentsEvent event) {
        this.channelBus.<ResourceKey<CreativeModeTab>, Holder<Item>>forEach(DataChannels.CREATIVE_MODE_TAB_EVENT_HANDLER,
                (tab, items) ->
                        this.addItemsToCreativeTab(event, tab, items));
    }

    private void addItemsToCreativeTab(BuildCreativeModeTabContentsEvent event, ResourceKey<CreativeModeTab> tab, Queue<Holder<Item>> items) {
        this.tabAdder.addAllToTab(event, tab, HolderUtils.unwrapToList(items));
    }
}
