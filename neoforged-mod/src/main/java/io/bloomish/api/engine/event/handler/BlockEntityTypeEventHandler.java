package io.bloomish.api.engine.event.handler;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.KeyedQueueChannelBus;
import io.bloomish.api.engine.event.subscriber.ModEventBusSubscriber;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.HolderUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

import java.util.Queue;

@Injected
@Handler(BlockEntityTypeAddBlocksEvent.class)
public class BlockEntityTypeEventHandler extends AbstractEventHandler<BlockEntityTypeAddBlocksEvent> {
    private final KeyedQueueChannelBus channelBus;

    public BlockEntityTypeEventHandler(ModEventBusSubscriber eventBusSubscriber, KeyedQueueChannelBus channelBus) {
        super(eventBusSubscriber);
        this.channelBus = channelBus;
    }

    @Override
    protected void handle(BlockEntityTypeAddBlocksEvent event) {
        this.channelBus.<BlockEntityType<?>, Holder<Block>>forEachDrain(DataChannels.BLOCK_ENTITY_TYPE_EVENT_HANDLER,
                (blockEntityType, blocks) ->
                        this.addBlocksToEntityType(event, blockEntityType, blocks));
    }

    private void addBlocksToEntityType(BlockEntityTypeAddBlocksEvent event, BlockEntityType<?> blockEntityType, Queue<Holder<Block>> blocks) {
        event.modify(blockEntityType, HolderUtils.unwrapToArray(blocks));
    }
}
