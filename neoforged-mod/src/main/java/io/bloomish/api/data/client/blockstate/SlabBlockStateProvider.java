package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;

import java.util.Map;

@Injected
public class SlabBlockStateProvider extends AbstractBlockStateProvider {
    private static final String TOP_SUFFIX = "_top";
    private static final String TYPE = "type";
    private static final String BOTTOM = "bottom";
    private static final String DOUBLE = "double";
    private static final String TOP = "top";

    private final ValueChannelBus channelBus;

    public SlabBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<SlabBlockHolder>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_SLAB_BLOCKS, holder -> {
            Block block = holder.getBlock();
            String path = this.blockPath(block);
            BlockState blockState = this.createSlabBlockState(path, holder.fullBlockPath());
            this.addBlockState(block, blockState);
        });
    }

    private VariantBlockState createSlabBlockState(String path, String fullBlockPath) {
        return VariantBlockState.of(Map.of(
                Map.of(TYPE, BOTTOM), Variant.ofModel(path),
                Map.of(TYPE, DOUBLE), Variant.ofModel(fullBlockPath),
                Map.of(TYPE, TOP), Variant.ofModel(this.topModel(path))
        ));
    }

    private String topModel(String path) {
        return path + TOP_SUFFIX;
    }

    public record SlabBlockHolder(
            Holder<? extends SlabBlock> holder,
            String fullBlockPath
    ) {
        public SlabBlock getBlock() {
            return this.holder.value();
        }
    }
}