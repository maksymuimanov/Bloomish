package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import java.util.Map;

@Injected
public class AxisBlockStateProvider extends AbstractBlockStateProvider {
    private static final String AXIS = "axis";
    private static final String X = "x";
    private static final String Y = "y";
    private static final String Z = "z";
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
        Map<Map<String, String>, Variant> variants = Map.of(
                Map.of(AXIS, X), Variant.ofX90Y90(path),
                Map.of(AXIS, Y), Variant.ofModel(path),
                Map.of(AXIS, Z), Variant.ofX90(path)
        );
        return VariantBlockState.of(variants);
    }
}
