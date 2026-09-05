package io.bloomish.api.event.listener;

import io.bloomish.api.channel.deprecated.DataChannels;
import io.bloomish.api.channel.deprecated.KeyedQueueChannelBus;
import io.bloomish.api.util.HolderUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

import java.util.Queue;

@EventListener
public class BlockEntityTypeEventListener {
    private final KeyedQueueChannelBus channelBus;

    public BlockEntityTypeEventListener(KeyedQueueChannelBus channelBus) {
        this.channelBus = channelBus;
    }

    public void listen(BlockEntityTypeAddBlocksEvent event) {
        this.channelBus.<BlockEntityType<?>, Holder<Block>>forEachDrain(DataChannels.BLOCK_ENTITY_TYPE_EVENT_HANDLER,
                (blockEntityType, blocks) ->
                        this.addBlocksToEntityType(event, blockEntityType, blocks));
    }

    private void addBlocksToEntityType(BlockEntityTypeAddBlocksEvent event, BlockEntityType<?> blockEntityType, Queue<Holder<Block>> blocks) {
        event.modify(blockEntityType, HolderUtils.unwrapToArray(blocks));
    }
}
