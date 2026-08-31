package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import java.util.Map;

@Injected
public class PressurePlateBlockStateProvider extends AbstractBlockStateProvider {
    private static final String DOWN_SUFFIX = "_down";
    private static final String POWERED = "powered";
    private static final String TRUE = "true";
    private static final String FALSE = "false";
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
        return VariantBlockState.of(Map.of(
                Map.of(POWERED, FALSE), this.createVariant(path, false),
                Map.of(POWERED, TRUE), this.createVariant(path, true)
        ));
    }

    private VariantBlockState.Variant createVariant(String path, boolean powered) {
        String model = powered ? path + DOWN_SUFFIX : path;
        return VariantBlockState.Variant.of(model);
    }
}
