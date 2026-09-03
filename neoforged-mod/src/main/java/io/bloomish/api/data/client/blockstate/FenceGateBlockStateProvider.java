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
public class FenceGateBlockStateProvider extends AbstractBlockStateProvider {
    private static final String OPEN_SUFFIX = "open";
    private static final String WALL_SUFFIX = "wall";
    private final ValueChannelBus channelBus;

    public FenceGateBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_FENCE_GATE_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createFenceGateBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private VariantBlockState createFenceGateBlockState(String path) {
        return VariantBlockState.ofConditionalVariants(
                ConditionalVariant.of(Variant.ofUvlockY270(path), Facing.EAST, InWall.FALSE, Open.FALSE),
                ConditionalVariant.of(Variant.ofUvlockY270(this.openModel(path)), Facing.EAST, InWall.FALSE, Open.TRUE),
                ConditionalVariant.of(Variant.ofUvlockY270(this.wallModel(path)), Facing.EAST, InWall.TRUE, Open.FALSE),
                ConditionalVariant.of(Variant.ofUvlockY270(this.openWallModel(path)), Facing.EAST, InWall.TRUE, Open.TRUE),
                ConditionalVariant.of(Variant.ofUvlockY180(path), Facing.NORTH, InWall.FALSE, Open.FALSE),
                ConditionalVariant.of(Variant.ofUvlockY180(this.openModel(path)), Facing.NORTH, InWall.FALSE, Open.TRUE),
                ConditionalVariant.of(Variant.ofUvlockY180(this.wallModel(path)), Facing.NORTH, InWall.TRUE, Open.FALSE),
                ConditionalVariant.of(Variant.ofUvlockY180(this.openWallModel(path)), Facing.NORTH, InWall.TRUE, Open.TRUE),
                ConditionalVariant.of(Variant.ofUvlockModel(path), Facing.SOUTH, InWall.FALSE, Open.FALSE),
                ConditionalVariant.of(Variant.ofUvlockModel(this.openModel(path)), Facing.SOUTH, InWall.FALSE, Open.TRUE),
                ConditionalVariant.of(Variant.ofUvlockModel(this.wallModel(path)), Facing.SOUTH, InWall.TRUE, Open.FALSE),
                ConditionalVariant.of(Variant.ofUvlockModel(this.openWallModel(path)), Facing.SOUTH, InWall.TRUE, Open.TRUE),
                ConditionalVariant.of(Variant.ofUvlockY90(path), Facing.WEST, InWall.FALSE, Open.FALSE),
                ConditionalVariant.of(Variant.ofUvlockY90(this.openModel(path)), Facing.WEST, InWall.FALSE, Open.TRUE),
                ConditionalVariant.of(Variant.ofUvlockY90(this.wallModel(path)), Facing.WEST, InWall.TRUE, Open.FALSE),
                ConditionalVariant.of(Variant.ofUvlockY90(this.openWallModel(path)), Facing.WEST, InWall.TRUE, Open.TRUE)
        );
    }

    private String openWallModel(String path) {
        return StringUtils.joinWithUnderscore(path, WALL_SUFFIX, OPEN_SUFFIX);
    }

    private String openModel(String path) {
        return StringUtils.joinWithUnderscore(path, OPEN_SUFFIX);
    }

    private String wallModel(String path) {
        return StringUtils.joinWithUnderscore(path, WALL_SUFFIX);
    }

    private enum InWall implements EnumBlockStateProperty {
        TRUE, FALSE
    }
}
