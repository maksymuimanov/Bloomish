package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.blockstate.property.BlockStateProperty;
import io.bloomish.api.data.client.blockstate.property.EnumBlockStateProperty;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.StringUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

@Injected
public class WallBlockStateProvider extends AbstractBlockStateProvider {
    private static final String POST_SUFFIX = "post";
    private static final String SIDE_SUFFIX = "side";
    private static final String SIDE_TALL_SUFFIX = "side_tall";
    private final ValueChannelBus channelBus;

    public WallBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_WALL_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createWallBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private MultipartBlockState createWallBlockState(String path) {
        return MultipartBlockState.of(
                MultipartBlockState.Part.of(Variant.ofModel(this.postModel(path)), Up.TRUE),
                MultipartBlockState.Part.of(Variant.ofUvlockModel(this.sideModel(path)), WallFacing.LOW_NORTH),
                MultipartBlockState.Part.of(Variant.ofUvlockY90(this.sideModel(path)), WallFacing.LOW_EAST),
                MultipartBlockState.Part.of(Variant.ofUvlockY180(this.sideModel(path)), WallFacing.LOW_SOUTH), 
                MultipartBlockState.Part.of(Variant.ofUvlockY270(this.sideModel(path)), WallFacing.LOW_WEST),
                MultipartBlockState.Part.of(Variant.ofUvlockModel(this.sideTallModel(path)), WallFacing.TALL_NORTH),
                MultipartBlockState.Part.of(Variant.ofUvlockY90(this.sideTallModel(path)), WallFacing.TALL_EAST),
                MultipartBlockState.Part.of(Variant.ofUvlockY180(this.sideTallModel(path)), WallFacing.TALL_SOUTH),
                MultipartBlockState.Part.of(Variant.ofUvlockY270(this.sideTallModel(path)), WallFacing.TALL_WEST)
        );
    }

    private String postModel(String path) {
        return StringUtils.joinWithUnderscore(path, POST_SUFFIX);
    }

    private String sideModel(String path) {
        return StringUtils.joinWithUnderscore(path, SIDE_SUFFIX);
    }

    private String sideTallModel(String path) {
        return StringUtils.joinWithUnderscore(path, SIDE_TALL_SUFFIX);
    }
    
    private enum Up implements EnumBlockStateProperty {
        TRUE
    }
    
    private enum WallFacing implements BlockStateProperty {
        LOW_NORTH("north", "low"),
        LOW_EAST("east", "low"),
        LOW_SOUTH("south", "low"),
        LOW_WEST("west", "low"),
        TALL_NORTH("north", "tall"),
        TALL_EAST("east", "tall"),
        TALL_SOUTH("south", "tall"),
        TALL_WEST("west", "tall");

        private final String key;
        private final String value;
        
        WallFacing(String key, String value) {
            this.key = key;
            this.value = value;
        }
        
        @Override
        public String getKey() {
            return this.key;
        }
        
        @Override
        public String getValue() {
            return this.value;
        }
    }
}
