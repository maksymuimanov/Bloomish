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
public class DoorBlockStateProvider extends AbstractBlockStateProvider {
    private static final String BOTTOM_SUFFIX = "_bottom";
    private static final String TOP_SUFFIX = "_top";
    private static final String OPEN_SUFFIX = "_open";
    private static final String LEFT_SUFFIX = "_left";
    private static final String RIGHT_SUFFIX = "_right";
    private static final String FACING = "facing";
    private static final String HALF = "half";
    private static final String HINGE = "hinge";
    private static final String OPEN = "open";
    private static final String LOWER = "lower";
    private static final String UPPER = "upper";
    private static final String LEFT = "left";
    private static final String RIGHT = "right";
    private static final String EAST = "east";
    private static final String NORTH = "north";
    private static final String SOUTH = "south";
    private static final String WEST = "west";
    private static final String TRUE = "true";
    private static final String FALSE = "false";
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
        Map<Map<String, String>, Variant> variants = new HashMap<>();
        this.createEastVariants(path, variants);
        this.createNorthVariants(path, variants);
        this.createSouthVariants(path, variants);
        this.createWestVariants(path, variants);
        return VariantBlockState.of(variants);
    }

    private void createEastVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, EAST, HALF, LOWER, HINGE, LEFT, OPEN, FALSE), Variant.ofY90(this.bottomLeftModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, LOWER, HINGE, LEFT, OPEN, TRUE), Variant.ofY90(this.openBottomLeftModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, LOWER, HINGE, RIGHT, OPEN, FALSE), Variant.ofY270(this.bottomRightModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, LOWER, HINGE, RIGHT, OPEN, TRUE), Variant.ofY270(this.openBottomRightModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, UPPER, HINGE, LEFT, OPEN, FALSE), Variant.ofY90(this.topLeftModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, UPPER, HINGE, LEFT, OPEN, TRUE), Variant.ofY90(this.openTopLeftModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, UPPER, HINGE, RIGHT, OPEN, FALSE), Variant.ofY270(this.topRightModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, UPPER, HINGE, RIGHT, OPEN, TRUE), Variant.ofY270(this.openTopRightModel(path)));
    }

    private void createNorthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, NORTH, HALF, LOWER, HINGE, LEFT, OPEN, FALSE), Variant.ofY270(this.bottomLeftModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, LOWER, HINGE, LEFT, OPEN, TRUE), Variant.ofY270(this.openBottomLeftModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, LOWER, HINGE, RIGHT, OPEN, FALSE), Variant.ofY270(this.bottomRightModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, LOWER, HINGE, RIGHT, OPEN, TRUE), Variant.ofY270(this.openBottomRightModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, UPPER, HINGE, LEFT, OPEN, FALSE), Variant.ofY270(this.topLeftModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, UPPER, HINGE, LEFT, OPEN, TRUE), Variant.ofY270(this.openTopLeftModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, UPPER, HINGE, RIGHT, OPEN, FALSE), Variant.ofY270(this.topRightModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, UPPER, HINGE, RIGHT, OPEN, TRUE), Variant.ofY270(this.openTopRightModel(path)));
    }

    private void createSouthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, SOUTH, HALF, LOWER, HINGE, LEFT, OPEN, FALSE), Variant.ofY90(this.bottomLeftModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, LOWER, HINGE, LEFT, OPEN, TRUE), Variant.ofY90(this.openBottomLeftModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, LOWER, HINGE, RIGHT, OPEN, FALSE), Variant.ofY90(this.bottomRightModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, LOWER, HINGE, RIGHT, OPEN, TRUE), Variant.ofY90(this.openBottomRightModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, UPPER, HINGE, LEFT, OPEN, FALSE), Variant.ofY90(this.topLeftModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, UPPER, HINGE, LEFT, OPEN, TRUE), Variant.ofY90(this.openTopLeftModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, UPPER, HINGE, RIGHT, OPEN, FALSE), Variant.ofY90(this.topRightModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, UPPER, HINGE, RIGHT, OPEN, TRUE), Variant.ofY90(this.openTopRightModel(path)));
    }

    private void createWestVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, WEST, HALF, LOWER, HINGE, LEFT, OPEN, FALSE), Variant.ofY180(this.bottomLeftModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, LOWER, HINGE, LEFT, OPEN, TRUE), Variant.ofY180(this.openBottomLeftModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, LOWER, HINGE, RIGHT, OPEN, FALSE), Variant.ofY180(this.bottomRightModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, LOWER, HINGE, RIGHT, OPEN, TRUE), Variant.ofY180(this.openBottomRightModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, UPPER, HINGE, LEFT, OPEN, FALSE), Variant.ofY180(this.topLeftModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, UPPER, HINGE, LEFT, OPEN, TRUE), Variant.ofY180(this.openTopLeftModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, UPPER, HINGE, RIGHT, OPEN, FALSE), Variant.ofY180(this.topRightModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, UPPER, HINGE, RIGHT, OPEN, TRUE), Variant.ofY180(this.openTopRightModel(path)));
    }

    private String bottomLeftModel(String path) {
        return path + BOTTOM_SUFFIX + LEFT_SUFFIX;
    }

    private String bottomRightModel(String path) {
        return path + BOTTOM_SUFFIX + RIGHT_SUFFIX;
    }

    private String topLeftModel(String path) {
        return path + TOP_SUFFIX + LEFT_SUFFIX;
    }

    private String topRightModel(String path) {
        return path + TOP_SUFFIX + RIGHT_SUFFIX;
    }

    private String openBottomLeftModel(String path) {
        return this.bottomLeftModel(path) + OPEN_SUFFIX;
    }

    private String openBottomRightModel(String path) {
        return this.bottomRightModel(path) + OPEN_SUFFIX;
    }

    private String openTopLeftModel(String path) {
        return this.topLeftModel(path) + OPEN_SUFFIX;
    }

    private String openTopRightModel(String path) {
        return this.topRightModel(path) + OPEN_SUFFIX;
    }
}
