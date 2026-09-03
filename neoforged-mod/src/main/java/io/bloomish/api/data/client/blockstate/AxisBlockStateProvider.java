package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.blockstate.property.Axis;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

@Injected
public class AxisBlockStateProvider extends AbstractBlockStateProvider {
    private final ValueChannelBus channelBus;

    public AxisBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_AXIS_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createColumnBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private VariantBlockState createColumnBlockState(String path) {
        return VariantBlockState.ofConditionalVariants(
                ConditionalVariant.of(Variant.ofX90Y90(path), Axis.X),
                ConditionalVariant.of(Variant.ofModel(path), Axis.Y),
                ConditionalVariant.of(Variant.ofX90(path), Axis.Z)
        );
    }
}
