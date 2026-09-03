package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.blockstate.property.Facing;
import io.bloomish.api.data.client.blockstate.property.Half;
import io.bloomish.api.data.client.blockstate.property.Open;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.StringUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

@Injected
public class TrapdoorBlockStateProvider extends AbstractBlockStateProvider {
    private static final String BOTTOM_SUFFIX = "bottom";
    private static final String TOP_SUFFIX = "top";
    private static final String OPEN_SUFFIX = "open";
    private final ValueChannelBus channelBus;

    public TrapdoorBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_TRAPDOOR_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createTrapdoorBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private VariantBlockState createTrapdoorBlockState(String path) {
        return VariantBlockState.ofConditionalVariants(
                ConditionalVariant.of(Variant.ofY90(this.bottomModel(path)), Facing.EAST, Half.BOTTOM, Open.FALSE),
                ConditionalVariant.of(Variant.ofY90(this.openBottomModel(path)), Facing.EAST, Half.BOTTOM, Open.TRUE),
                ConditionalVariant.of(Variant.ofY90(this.topModel(path)), Facing.EAST, Half.TOP, Open.FALSE),
                ConditionalVariant.of(Variant.ofX180Y270(this.openModel(path)), Facing.EAST, Half.TOP, Open.TRUE),
                ConditionalVariant.of(Variant.ofModel(this.bottomModel(path)), Facing.NORTH, Half.BOTTOM, Open.FALSE),
                ConditionalVariant.of(Variant.ofModel(this.openBottomModel(path)), Facing.NORTH, Half.BOTTOM, Open.TRUE),
                ConditionalVariant.of(Variant.ofModel(this.topModel(path)), Facing.NORTH, Half.TOP, Open.FALSE),
                ConditionalVariant.of(Variant.ofX180Y180(this.openModel(path)), Facing.NORTH, Half.TOP, Open.TRUE),
                ConditionalVariant.of(Variant.ofY180(this.bottomModel(path)), Facing.SOUTH, Half.BOTTOM, Open.FALSE),
                ConditionalVariant.of(Variant.ofY180(this.openBottomModel(path)), Facing.SOUTH, Half.BOTTOM, Open.TRUE),
                ConditionalVariant.of(Variant.ofY180(this.topModel(path)), Facing.SOUTH, Half.TOP, Open.FALSE),
                ConditionalVariant.of(Variant.ofX180Y0(this.openModel(path)), Facing.SOUTH, Half.TOP, Open.TRUE),
                ConditionalVariant.of(Variant.ofY270(this.bottomModel(path)), Facing.WEST, Half.BOTTOM, Open.FALSE),
                ConditionalVariant.of(Variant.ofY270(this.openBottomModel(path)), Facing.WEST, Half.BOTTOM, Open.TRUE),
                ConditionalVariant.of(Variant.ofY270(this.topModel(path)), Facing.WEST, Half.TOP, Open.FALSE),
                ConditionalVariant.of(Variant.ofX180Y90(this.openModel(path)), Facing.WEST, Half.TOP, Open.TRUE)
        );
    }

    private String openBottomModel(String path) {
        return StringUtils.joinWithUnderscore(path, OPEN_SUFFIX, BOTTOM_SUFFIX);
    }

    private String openModel(String path) {
        return StringUtils.joinWithUnderscore(path, OPEN_SUFFIX);
    }

    private String bottomModel(String path) {
        return StringUtils.joinWithUnderscore(path, BOTTOM_SUFFIX);
    }

    private String topModel(String path) {
        return StringUtils.joinWithUnderscore(path, TOP_SUFFIX);
    }
}