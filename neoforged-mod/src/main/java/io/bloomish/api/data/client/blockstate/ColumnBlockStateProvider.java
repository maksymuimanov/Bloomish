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
    private static final String AXIS = "axis";
    private static final String X = "x";
    private static final String Y = "y";
    private static final String Z = "z";
    private static final int ROTATION_90 = 90;
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
        Map<Map<String, String>, Variant> variants = Map.of(
                Map.of(AXIS, X), new Variant(this.horizontalModel(path), ROTATION_90, ROTATION_90),
                Map.of(AXIS, Y), new Variant(path),
                Map.of(AXIS, Z), Variant.ofX(this.horizontalModel(path), ROTATION_90)
        );
        return VariantBlockState.of(variants);
    }

    private String horizontalModel(String path) {
        return path + HORIZONTAL_SUFFIX;
    }
}
