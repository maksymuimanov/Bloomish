package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import java.util.Map;

@Injected
public class SingleVariantBlockStateProvider extends AbstractBlockStateProvider {
    private final ValueChannelBus channelBus;

    public SingleVariantBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_SINGLE_VARIANT_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createSingleVariantBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private VariantBlockState createSingleVariantBlockState(String path) {
        VariantBlockState.Variant variant = VariantBlockState.Variant.of(path);
        Map<String, VariantBlockState.Variant> variants = Map.of("", variant);
        return new VariantBlockState(variants);
    }
}
