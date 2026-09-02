package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

@Injected
public class FenceGateBlockStateProvider extends AbstractBlockStateProvider {
    private static final String OPEN_SUFFIX = "_open";
    private static final String WALL_SUFFIX = "_wall";
    private static final String FACING = "facing";
    private static final String IN_WALL = "in_wall";
    private static final String OPEN = "open";
    private static final String EAST = "east";
    private static final String NORTH = "north";
    private static final String SOUTH = "south";
    private static final String WEST = "west";
    private static final String TRUE = "true";
    private static final String FALSE = "false";
    private static final int ROTATION_90 = 90;
    private static final int ROTATION_180 = 180;
    private static final int ROTATION_270 = 270;
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
        Map<Map<String, String>, Variant> variants = new HashMap<>();
        this.createEastVariants(path, variants);
        this.createNorthVariants(path, variants);
        this.createSouthVariants(path, variants);
        this.createWestVariants(path, variants);
        return VariantBlockState.of(variants);
    }

    private void createEastVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, EAST, IN_WALL, FALSE, OPEN, FALSE), Variant.ofUvlockY(path, ROTATION_270));
        variants.put(Map.of(FACING, EAST, IN_WALL, FALSE, OPEN, TRUE), Variant.ofUvlockY(this.openModel(path), ROTATION_270));
        variants.put(Map.of(FACING, EAST, IN_WALL, TRUE, OPEN, FALSE), Variant.ofUvlockY(this.wallModel(path), ROTATION_270));
        variants.put(Map.of(FACING, EAST, IN_WALL, TRUE, OPEN, TRUE), Variant.ofUvlockY(this.openWallModel(path), ROTATION_270));
    }

    private void createNorthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, NORTH, IN_WALL, FALSE, OPEN, FALSE), Variant.ofUvlockY(path, ROTATION_180));
        variants.put(Map.of(FACING, NORTH, IN_WALL, FALSE, OPEN, TRUE), Variant.ofUvlockY(this.openModel(path), ROTATION_180));
        variants.put(Map.of(FACING, NORTH, IN_WALL, TRUE, OPEN, FALSE), Variant.ofUvlockY(this.wallModel(path), ROTATION_180));
        variants.put(Map.of(FACING, NORTH, IN_WALL, TRUE, OPEN, TRUE), Variant.ofUvlockY(this.openWallModel(path), ROTATION_180));
    }

    private void createSouthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, SOUTH, IN_WALL, FALSE, OPEN, FALSE), Variant.ofUvlockModel(path));
        variants.put(Map.of(FACING, SOUTH, IN_WALL, FALSE, OPEN, TRUE), Variant.ofUvlockModel(this.openModel(path)));
        variants.put(Map.of(FACING, SOUTH, IN_WALL, TRUE, OPEN, FALSE), Variant.ofUvlockModel(this.wallModel(path)));
        variants.put(Map.of(FACING, SOUTH, IN_WALL, TRUE, OPEN, TRUE), Variant.ofUvlockModel(this.openWallModel(path)));
    }

    private void createWestVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, WEST, IN_WALL, FALSE, OPEN, FALSE), Variant.ofUvlockY(path, ROTATION_90));
        variants.put(Map.of(FACING, WEST, IN_WALL, FALSE, OPEN, TRUE), Variant.ofUvlockY(this.openModel(path), ROTATION_90));
        variants.put(Map.of(FACING, WEST, IN_WALL, TRUE, OPEN, FALSE), Variant.ofUvlockY(this.wallModel(path), ROTATION_90));
        variants.put(Map.of(FACING, WEST, IN_WALL, TRUE, OPEN, TRUE), Variant.ofUvlockY(this.openWallModel(path), ROTATION_90));
    }

    private String openModel(String path) {
        return path + OPEN_SUFFIX;
    }

    private String wallModel(String path) {
        return path + WALL_SUFFIX;
    }

    private String openWallModel(String path) {
        return this.wallModel(path) + OPEN_SUFFIX;
    }
}
