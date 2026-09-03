package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.blockstate.property.EnumBlockStateProperty;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.StringUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;

@Injected
public class SlabBlockStateProvider extends AbstractBlockStateProvider {
    private static final String TOP_SUFFIX = "top";
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
        return VariantBlockState.ofConditionalVariants(
                ConditionalVariant.of(Variant.ofModel(path), Type.BOTTOM),
                ConditionalVariant.of(Variant.ofModel(fullBlockPath), Type.DOUBLE),
                ConditionalVariant.of(Variant.ofModel(this.topModel(path)), Type.TOP)
        );
    }

    private String topModel(String path) {
        return StringUtils.joinWithUnderscore(path, TOP_SUFFIX);
    }

    public record SlabBlockHolder(
            Holder<? extends SlabBlock> holder,
            String fullBlockPath
    ) {
        public SlabBlock getBlock() {
            return this.holder.value();
        }
    }

    private enum Type implements EnumBlockStateProperty {
        BOTTOM, DOUBLE, TOP
    }
}