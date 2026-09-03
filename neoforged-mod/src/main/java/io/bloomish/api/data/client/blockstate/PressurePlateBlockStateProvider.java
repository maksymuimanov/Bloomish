package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.blockstate.property.Powered;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.StringUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

@Injected
public class PressurePlateBlockStateProvider extends AbstractBlockStateProvider {
    private static final String DOWN_SUFFIX = "down";
    private final ValueChannelBus channelBus;

    public PressurePlateBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_PRESSURE_PLATE_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createPressurePlateBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private VariantBlockState createPressurePlateBlockState(String path) {
        return VariantBlockState.ofConditionalVariants(
                ConditionalVariant.of(Variant.ofModel(path), Powered.FALSE),
                ConditionalVariant.of(Variant.ofModel(this.downModel(path)), Powered.TRUE)
        );
    }

    private String downModel(String path) {
        return StringUtils.joinWithUnderscore(path, DOWN_SUFFIX);
    }
}
