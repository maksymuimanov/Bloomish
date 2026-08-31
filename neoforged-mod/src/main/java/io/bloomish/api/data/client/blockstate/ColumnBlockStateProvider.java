package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import java.util.Map;

@Injected
public class ColumnBlockStateProvider extends AbstractBlockStateProvider {
    private static final String HORIZONTAL_SUFFIX = "_horizontal";
    private static final String AXIS_X = "axis=x";
    private static final String AXIS_Y = "axis=y";
    private static final String AXIS_Z = "axis=z";
    private static final int RIGHT_ANGLE = 90;
    private final ValueChannelBus channelBus;

    public ColumnBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_COLUMN_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createColumnBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private VariantBlockState createColumnBlockState(String path) {
        Map<String, VariantBlockState.Variant> variants = Map.of(
                AXIS_X, this.createXVariant(path),
                AXIS_Y, this.createYVariant(path),
                AXIS_Z, this.createZVariant(path)
        );
        return new VariantBlockState(variants);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    private VariantBlockState.Variant createXVariant(String path) {
        return VariantBlockState.Variant.of(path + HORIZONTAL_SUFFIX, RIGHT_ANGLE, RIGHT_ANGLE);
    }

    private VariantBlockState.Variant createYVariant(String path) {
        return VariantBlockState.Variant.of(path);
    }

    private VariantBlockState.Variant createZVariant(String path) {
        return VariantBlockState.Variant.of(path + HORIZONTAL_SUFFIX, RIGHT_ANGLE);
    }
}
