package io.bloomish.api.engine.event.handler;

import io.bloomish.api.channel.BiQueueChannelBus;
import io.bloomish.api.channel.Channels;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

import java.util.Collection;

@Injected
@Handler(BlockEntityTypeAddBlocksEvent.class)
public class BlockEntityTypeEventHandler implements EventHandler {
    private final BiQueueChannelBus biQueueChannelBus;

    public BlockEntityTypeEventHandler(BiQueueChannelBus biQueueChannelBus) {
        this.biQueueChannelBus = biQueueChannelBus;
    }

    @Override
    public void handle() {
        this.subscribeModEvent(BlockEntityTypeAddBlocksEvent.class, event -> {
            this.biQueueChannelBus.<BlockEntityType<?>, Holder<Block>>drain(Channels.BLOCK_ENTITY_TYPE_EVENT_HANDLER_BI_CHANNEL)
                    .forEach(entry -> {
                        BlockEntityType<?> type = entry.key();
                        Collection<Holder<Block>> holders = entry.value();
                        event.modify(type, holders.stream()
                                .map(Holder::value)
                                .toArray(Block[]::new));
                    });
        });
    }
}
