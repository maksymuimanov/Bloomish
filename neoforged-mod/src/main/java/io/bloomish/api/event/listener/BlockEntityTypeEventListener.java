package io.bloomish.api.event.listener;

import io.bloomish.api.channel.ObserveObjectChannel;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

import java.util.stream.Stream;

@EventListener
public class BlockEntityTypeEventListener {
    private final Stream<BlockEntityTypeBlock> blockEntityTypeBlocks;

    public BlockEntityTypeEventListener(
            @ObserveObjectChannel("BlockEntityTypeEventListener") Stream<BlockEntityTypeBlock> blockEntityTypeBlocks
    ) {
        this.blockEntityTypeBlocks = blockEntityTypeBlocks;
    }

    public void listen(BlockEntityTypeAddBlocksEvent event) {
        this.blockEntityTypeBlocks.forEach(blockEntityTypeBlock ->
                event.modify(blockEntityTypeBlock.blockEntityType(), blockEntityTypeBlock.block().value()));
    }

    public record BlockEntityTypeBlock(
            BlockEntityType<?> blockEntityType,
            Holder<? extends Block> block
    ) {
    }
}
