package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.blockstate.property.EnumBlockStateProperty;
import io.bloomish.api.data.client.blockstate.property.Facing;
import io.bloomish.api.data.client.blockstate.property.Open;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.StringUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

@Injected
public class DoorBlockStateProvider extends AbstractBlockStateProvider {
    private static final String BOTTOM_SUFFIX = "bottom";
    private static final String TOP_SUFFIX = "top";
    private static final String OPEN_SUFFIX = "open";
    private static final String LEFT_SUFFIX = "left";
    private static final String RIGHT_SUFFIX = "right";
    private final ValueChannelBus channelBus;

    public DoorBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_DOOR_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createDoorBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private VariantBlockState createDoorBlockState(String path) {
        return VariantBlockState.ofConditionalVariants(
                ConditionalVariant.of(Variant.ofY90(this.bottomLeftModel(path)), Facing.EAST, Half.LOWER, Hinge.LEFT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY90(this.openBottomLeftModel(path)), Facing.EAST, Half.LOWER, Hinge.LEFT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY270(this.bottomRightModel(path)), Facing.EAST, Half.LOWER, Hinge.RIGHT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY270(this.openBottomRightModel(path)), Facing.EAST, Half.LOWER, Hinge.RIGHT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY90(this.topLeftModel(path)), Facing.EAST, Half.UPPER, Hinge.LEFT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY90(this.openTopLeftModel(path)), Facing.EAST, Half.UPPER, Hinge.LEFT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY270(this.topRightModel(path)), Facing.EAST, Half.UPPER, Hinge.RIGHT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY270(this.openTopRightModel(path)), Facing.EAST, Half.UPPER, Hinge.RIGHT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY270(this.bottomLeftModel(path)), Facing.NORTH, Half.LOWER, Hinge.LEFT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY270(this.openBottomLeftModel(path)), Facing.NORTH, Half.LOWER, Hinge.LEFT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY270(this.bottomRightModel(path)), Facing.NORTH, Half.LOWER, Hinge.RIGHT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY270(this.openBottomRightModel(path)), Facing.NORTH, Half.LOWER, Hinge.RIGHT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY270(this.topLeftModel(path)), Facing.NORTH, Half.UPPER, Hinge.LEFT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY270(this.openTopLeftModel(path)), Facing.NORTH, Half.UPPER, Hinge.LEFT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY270(this.topRightModel(path)), Facing.NORTH, Half.UPPER, Hinge.RIGHT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY270(this.openTopRightModel(path)), Facing.NORTH, Half.UPPER, Hinge.RIGHT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY90(this.bottomLeftModel(path)), Facing.SOUTH, Half.LOWER, Hinge.LEFT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY90(this.openBottomLeftModel(path)), Facing.SOUTH, Half.LOWER, Hinge.LEFT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY90(this.bottomRightModel(path)), Facing.SOUTH, Half.LOWER, Hinge.RIGHT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY90(this.openBottomRightModel(path)), Facing.SOUTH, Half.LOWER, Hinge.RIGHT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY90(this.topLeftModel(path)), Facing.SOUTH, Half.UPPER, Hinge.LEFT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY90(this.openTopLeftModel(path)), Facing.SOUTH, Half.UPPER, Hinge.LEFT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY90(this.topRightModel(path)), Facing.SOUTH, Half.UPPER, Hinge.RIGHT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY90(this.openTopRightModel(path)), Facing.SOUTH, Half.UPPER, Hinge.RIGHT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY180(this.bottomLeftModel(path)), Facing.WEST, Half.LOWER, Hinge.LEFT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY180(this.openBottomLeftModel(path)), Facing.WEST, Half.LOWER, Hinge.LEFT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY180(this.bottomRightModel(path)), Facing.WEST, Half.LOWER, Hinge.RIGHT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY180(this.openBottomRightModel(path)), Facing.WEST, Half.LOWER, Hinge.RIGHT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY180(this.topLeftModel(path)), Facing.WEST, Half.UPPER, Hinge.LEFT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY180(this.openTopLeftModel(path)), Facing.WEST, Half.UPPER, Hinge.LEFT, Open.TRUE),
                ConditionalVariant.of(Variant.ofY180(this.topRightModel(path)), Facing.WEST, Half.UPPER, Hinge.RIGHT, Open.FALSE),
                ConditionalVariant.of(Variant.ofY180(this.openTopRightModel(path)), Facing.WEST, Half.UPPER, Hinge.RIGHT, Open.TRUE)
        );
    }

    private String openBottomLeftModel(String path) {
        return StringUtils.joinWithUnderscore(path, BOTTOM_SUFFIX, LEFT_SUFFIX, OPEN_SUFFIX);
    }

    private String openBottomRightModel(String path) {
        return StringUtils.joinWithUnderscore(path, BOTTOM_SUFFIX, RIGHT_SUFFIX, OPEN_SUFFIX);
    }

    private String openTopLeftModel(String path) {
        return StringUtils.joinWithUnderscore(path, TOP_SUFFIX, LEFT_SUFFIX, OPEN_SUFFIX);
    }

    private String openTopRightModel(String path) {
        return StringUtils.joinWithUnderscore(path, TOP_SUFFIX, RIGHT_SUFFIX, OPEN_SUFFIX);
    }

    private String bottomLeftModel(String path) {
        return StringUtils.joinWithUnderscore(path, BOTTOM_SUFFIX, LEFT_SUFFIX);
    }

    private String bottomRightModel(String path) {
        return StringUtils.joinWithUnderscore(path, BOTTOM_SUFFIX, RIGHT_SUFFIX);
    }

    private String topLeftModel(String path) {
        return StringUtils.joinWithUnderscore(path, TOP_SUFFIX, LEFT_SUFFIX);
    }

    private String topRightModel(String path) {
        return StringUtils.joinWithUnderscore(path, TOP_SUFFIX, RIGHT_SUFFIX);
    }

    private enum Half implements EnumBlockStateProperty {
        UPPER, LOWER
    }

    private enum Hinge implements EnumBlockStateProperty {
        LEFT, RIGHT
    }
}
