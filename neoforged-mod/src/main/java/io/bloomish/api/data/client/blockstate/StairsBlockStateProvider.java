package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.blockstate.property.EnumBlockStateProperty;
import io.bloomish.api.data.client.blockstate.property.Facing;
import io.bloomish.api.data.client.blockstate.property.Half;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.StringUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

@Injected
public class StairsBlockStateProvider extends AbstractBlockStateProvider {
    private static final String INNER_SUFFIX = "inner";
    private static final String OUTER_SUFFIX = "outer";
    private final ValueChannelBus channelBus;

    public StairsBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_STAIRS_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createStairsBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private VariantBlockState createStairsBlockState(String path) {
        return VariantBlockState.ofConditionalVariants(
                ConditionalVariant.of(Variant.ofUvlockY270(this.innerModel(path)), Facing.EAST, Half.BOTTOM, Shape.INNER_LEFT),
                ConditionalVariant.of(Variant.ofModel(this.innerModel(path)), Facing.EAST, Half.BOTTOM, Shape.INNER_RIGHT),
                ConditionalVariant.of(Variant.ofUvlockY270(this.outerModel(path)), Facing.EAST, Half.BOTTOM, Shape.OUTER_LEFT),
                ConditionalVariant.of(Variant.ofModel(this.outerModel(path)), Facing.EAST, Half.BOTTOM, Shape.OUTER_RIGHT),
                ConditionalVariant.of(Variant.ofModel(path), Facing.EAST, Half.BOTTOM, Shape.STRAIGHT),
                ConditionalVariant.of(Variant.ofUvlockX180(this.innerModel(path)), Facing.EAST, Half.TOP, Shape.INNER_LEFT),
                ConditionalVariant.of(Variant.ofX180Y90(this.innerModel(path)), Facing.EAST, Half.TOP, Shape.INNER_RIGHT),
                ConditionalVariant.of(Variant.ofUvlockX180(this.outerModel(path)), Facing.EAST, Half.TOP, Shape.OUTER_LEFT),
                ConditionalVariant.of(Variant.ofX180Y90(this.outerModel(path)), Facing.EAST, Half.TOP, Shape.OUTER_RIGHT),
                ConditionalVariant.of(Variant.ofUvlockX180(path), Facing.EAST, Half.TOP, Shape.STRAIGHT),
                ConditionalVariant.of(Variant.ofUvlockY180(this.innerModel(path)), Facing.NORTH, Half.BOTTOM, Shape.INNER_LEFT),
                ConditionalVariant.of(Variant.ofY270(this.innerModel(path)), Facing.NORTH, Half.BOTTOM, Shape.INNER_RIGHT),
                ConditionalVariant.of(Variant.ofY180(this.outerModel(path)), Facing.NORTH, Half.BOTTOM, Shape.OUTER_LEFT),
                ConditionalVariant.of(Variant.ofY270(this.outerModel(path)), Facing.NORTH, Half.BOTTOM, Shape.OUTER_RIGHT),
                ConditionalVariant.of(Variant.ofY270(path), Facing.NORTH, Half.BOTTOM, Shape.STRAIGHT),
                ConditionalVariant.of(Variant.ofX180Y270(this.innerModel(path)), Facing.NORTH, Half.TOP, Shape.INNER_LEFT),
                ConditionalVariant.of(Variant.ofX180Y180(this.innerModel(path)), Facing.NORTH, Half.TOP, Shape.INNER_RIGHT),
                ConditionalVariant.of(Variant.ofX180Y270(this.outerModel(path)), Facing.NORTH, Half.TOP, Shape.OUTER_LEFT),
                ConditionalVariant.of(Variant.ofX180Y180(this.outerModel(path)), Facing.NORTH, Half.TOP, Shape.OUTER_RIGHT),
                ConditionalVariant.of(Variant.ofX180Y270(path), Facing.NORTH, Half.TOP, Shape.STRAIGHT),
                ConditionalVariant.of(Variant.ofModel(this.innerModel(path)), Facing.SOUTH, Half.BOTTOM, Shape.INNER_LEFT),
                ConditionalVariant.of(Variant.ofUvlockY90(this.innerModel(path)), Facing.SOUTH, Half.BOTTOM, Shape.INNER_RIGHT),
                ConditionalVariant.of(Variant.ofModel(this.outerModel(path)), Facing.SOUTH, Half.BOTTOM, Shape.OUTER_LEFT),
                ConditionalVariant.of(Variant.ofUvlockY90(this.outerModel(path)), Facing.SOUTH, Half.BOTTOM, Shape.OUTER_RIGHT),
                ConditionalVariant.of(Variant.ofUvlockY90(path), Facing.SOUTH, Half.BOTTOM, Shape.STRAIGHT),
                ConditionalVariant.of(Variant.ofX180Y90(this.innerModel(path)), Facing.SOUTH, Half.TOP, Shape.INNER_LEFT),
                ConditionalVariant.of(Variant.ofX180Y180(this.innerModel(path)), Facing.SOUTH, Half.TOP, Shape.INNER_RIGHT),
                ConditionalVariant.of(Variant.ofX180Y90(this.outerModel(path)), Facing.SOUTH, Half.TOP, Shape.OUTER_LEFT),
                ConditionalVariant.of(Variant.ofX180Y180(this.outerModel(path)), Facing.SOUTH, Half.TOP, Shape.OUTER_RIGHT),
                ConditionalVariant.of(Variant.ofX180Y90(path), Facing.SOUTH, Half.TOP, Shape.STRAIGHT),
                ConditionalVariant.of(Variant.ofUvlockY90(this.innerModel(path)), Facing.WEST, Half.BOTTOM, Shape.INNER_LEFT),
                ConditionalVariant.of(Variant.ofY180(this.innerModel(path)), Facing.WEST, Half.BOTTOM, Shape.INNER_RIGHT),
                ConditionalVariant.of(Variant.ofY90(this.outerModel(path)), Facing.WEST, Half.BOTTOM, Shape.OUTER_LEFT),
                ConditionalVariant.of(Variant.ofY180(this.outerModel(path)), Facing.WEST, Half.BOTTOM, Shape.OUTER_RIGHT),
                ConditionalVariant.of(Variant.ofY180(path), Facing.WEST, Half.BOTTOM, Shape.STRAIGHT),
                ConditionalVariant.of(Variant.ofX180Y180(this.innerModel(path)), Facing.WEST, Half.TOP, Shape.INNER_LEFT),
                ConditionalVariant.of(Variant.ofX180Y270(this.innerModel(path)), Facing.WEST, Half.TOP, Shape.INNER_RIGHT),
                ConditionalVariant.of(Variant.ofX180Y180(this.outerModel(path)), Facing.WEST, Half.TOP, Shape.OUTER_LEFT),
                ConditionalVariant.of(Variant.ofX180Y270(this.outerModel(path)), Facing.WEST, Half.TOP, Shape.OUTER_RIGHT),
                ConditionalVariant.of(Variant.ofX180Y180(path), Facing.WEST, Half.TOP, Shape.STRAIGHT)
        );
    }

    private String innerModel(String path) {
        return StringUtils.joinWithUnderscore(path, INNER_SUFFIX);
    }

    private String outerModel(String path) {
        return StringUtils.joinWithUnderscore(path, OUTER_SUFFIX);
    }

    private enum Shape implements EnumBlockStateProperty {
        INNER_LEFT, INNER_RIGHT, OUTER_LEFT, OUTER_RIGHT, STRAIGHT
    }
}
