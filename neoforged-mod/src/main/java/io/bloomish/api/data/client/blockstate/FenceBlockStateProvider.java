package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.blockstate.property.BlockStateProperty;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.StringUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import java.util.Locale;

@Injected
public class FenceBlockStateProvider extends AbstractBlockStateProvider {
    private static final String POST_SUFFIX = "post";
    private static final String SIDE_SUFFIX = "side";
    private final ValueChannelBus channelBus;

    public FenceBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_FENCE_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createFenceBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private MultipartBlockState createFenceBlockState(String path) {
        return MultipartBlockState.of(
                new MultipartBlockState.Part(Variant.ofModel(this.postModel(path))),
                MultipartBlockState.Part.of(Variant.ofUvlockModel(this.sideModel(path)), FenceFacing.NORTH),
                MultipartBlockState.Part.of(Variant.ofUvlockY90(this.sideModel(path)), FenceFacing.EAST),
                MultipartBlockState.Part.of(Variant.ofUvlockY180(this.sideModel(path)), FenceFacing.SOUTH),
                MultipartBlockState.Part.of(Variant.ofUvlockY270(this.sideModel(path)), FenceFacing.WEST)
        );
    }

    private String postModel(String path) {
        return StringUtils.joinWithUnderscore(path, POST_SUFFIX);
    }

    private String sideModel(String path) {
        return StringUtils.joinWithUnderscore(path, SIDE_SUFFIX);
    }

    private enum FenceFacing implements BlockStateProperty {
        WEST(true),
        EAST(true),
        NORTH(true),
        SOUTH(true);

        private final boolean value;

        FenceFacing(boolean value) {
            this.value = value;
        }

        @Override
        public String getKey() {
            return this.name().toLowerCase(Locale.ROOT);
        }

        @Override
        public String getValue() {
            return String.valueOf(this.value);
        }
    }
}