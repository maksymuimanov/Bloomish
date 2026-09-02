package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import java.util.List;

@Injected
public class FenceBlockStateProvider extends AbstractBlockStateProvider {
    private static final String POST_SUFFIX = "_post";
    private static final String SIDE_SUFFIX = "_side";
    private static final String NORTH = "north";
    private static final String EAST = "east";
    private static final String SOUTH = "south";
    private static final String WEST = "west";
    private static final String TRUE = "true";
    private static final int ROTATION_90 = 90;
    private static final int ROTATION_180 = 180;
    private static final int ROTATION_270 = 270;
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
        return new MultipartBlockState(
                List.of(
                        new MultipartBlockState.Part(
                                Variant.ofModel(this.postModel(path))
                        ),
                        new MultipartBlockState.Part(
                                Variant.ofUvlockModel(this.sideModel(path)),
                                NORTH, TRUE
                        ),
                        new MultipartBlockState.Part(
                                Variant.ofUvlockY(this.sideModel(path), ROTATION_90),
                                EAST, TRUE
                        ),
                        new MultipartBlockState.Part(
                                Variant.ofUvlockY(this.sideModel(path), ROTATION_180),
                                SOUTH, TRUE
                        ),
                        new MultipartBlockState.Part(
                                Variant.ofUvlockY(this.sideModel(path), ROTATION_270),
                                WEST, TRUE
                        )
                )
        );
    }

    private String postModel(String path) {
        return path + POST_SUFFIX;
    }

    private String sideModel(String path) {
        return path + SIDE_SUFFIX;
    }
}