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
    private static final int ROTATION_90 = 90;
    private static final int ROTATION_180 = 180;
    private static final int ROTATION_270 = 270;
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
        variants.put(Map.of(FACING, EAST, HALF, LOWER, HINGE, LEFT, OPEN, FALSE), this.createEastLowerLeftVariant(path, false));
        variants.put(Map.of(FACING, EAST, HALF, LOWER, HINGE, LEFT, OPEN, TRUE), this.createEastLowerLeftVariant(path, true));
        variants.put(Map.of(FACING, EAST, HALF, LOWER, HINGE, RIGHT, OPEN, FALSE), this.createEastLowerRightVariant(path, false));
        variants.put(Map.of(FACING, EAST, HALF, LOWER, HINGE, RIGHT, OPEN, TRUE), this.createEastLowerRightVariant(path, true));
        variants.put(Map.of(FACING, EAST, HALF, UPPER, HINGE, LEFT, OPEN, FALSE), this.createEastUpperLeftVariant(path, false));
        variants.put(Map.of(FACING, EAST, HALF, UPPER, HINGE, LEFT, OPEN, TRUE), this.createEastUpperLeftVariant(path, true));
        variants.put(Map.of(FACING, EAST, HALF, UPPER, HINGE, RIGHT, OPEN, FALSE), this.createEastUpperRightVariant(path, false));
        variants.put(Map.of(FACING, EAST, HALF, UPPER, HINGE, RIGHT, OPEN, TRUE), this.createEastUpperRightVariant(path, true));
    }

    private Variant createEastLowerLeftVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX + LEFT_SUFFIX, open, ROTATION_90);
    }

    private Variant createEastLowerRightVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX + RIGHT_SUFFIX, open, ROTATION_270);
    }

    private Variant createEastUpperLeftVariant(String path, boolean open) {
        return this.createVariant(path + TOP_SUFFIX + LEFT_SUFFIX, open, ROTATION_90);
    }

    private Variant createEastUpperRightVariant(String path, boolean open) {
        return this.createVariant(path + TOP_SUFFIX + RIGHT_SUFFIX, open, ROTATION_270);
    }

    private void createNorthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, NORTH, HALF, LOWER, HINGE, LEFT, OPEN, FALSE), this.createNorthLowerLeftVariant(path, false));
        variants.put(Map.of(FACING, NORTH, HALF, LOWER, HINGE, LEFT, OPEN, TRUE), this.createNorthLowerLeftVariant(path, true));
        variants.put(Map.of(FACING, NORTH, HALF, LOWER, HINGE, RIGHT, OPEN, FALSE), this.createNorthLowerRightVariant(path, false));
        variants.put(Map.of(FACING, NORTH, HALF, LOWER, HINGE, RIGHT, OPEN, TRUE), this.createNorthLowerRightVariant(path, true));
        variants.put(Map.of(FACING, NORTH, HALF, UPPER, HINGE, LEFT, OPEN, FALSE), this.createNorthUpperLeftVariant(path, false));
        variants.put(Map.of(FACING, NORTH, HALF, UPPER, HINGE, LEFT, OPEN, TRUE), this.createNorthUpperLeftVariant(path, true));
        variants.put(Map.of(FACING, NORTH, HALF, UPPER, HINGE, RIGHT, OPEN, FALSE), this.createNorthUpperRightVariant(path, false));
        variants.put(Map.of(FACING, NORTH, HALF, UPPER, HINGE, RIGHT, OPEN, TRUE), this.createNorthUpperRightVariant(path, true));
    }

    private Variant createNorthLowerLeftVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX + LEFT_SUFFIX, open, ROTATION_270);
    }

    private Variant createNorthLowerRightVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX + RIGHT_SUFFIX, open, ROTATION_270);
    }

    private Variant createNorthUpperLeftVariant(String path, boolean open) {
        return this.createVariant(path + TOP_SUFFIX + LEFT_SUFFIX, open, ROTATION_270);
    }

    private Variant createNorthUpperRightVariant(String path, boolean open) {
        return this.createVariant(path + TOP_SUFFIX + RIGHT_SUFFIX, open, ROTATION_270);
    }

    private void createSouthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, SOUTH, HALF, LOWER, HINGE, LEFT, OPEN, FALSE), this.createSouthLowerLeftVariant(path, false));
        variants.put(Map.of(FACING, SOUTH, HALF, LOWER, HINGE, LEFT, OPEN, TRUE), this.createSouthLowerLeftVariant(path, true));
        variants.put(Map.of(FACING, SOUTH, HALF, LOWER, HINGE, RIGHT, OPEN, FALSE), this.createSouthLowerRightVariant(path, false));
        variants.put(Map.of(FACING, SOUTH, HALF, LOWER, HINGE, RIGHT, OPEN, TRUE), this.createSouthLowerRightVariant(path, true));
        variants.put(Map.of(FACING, SOUTH, HALF, UPPER, HINGE, LEFT, OPEN, FALSE), this.createSouthUpperLeftVariant(path, false));
        variants.put(Map.of(FACING, SOUTH, HALF, UPPER, HINGE, LEFT, OPEN, TRUE), this.createSouthUpperLeftVariant(path, true));
        variants.put(Map.of(FACING, SOUTH, HALF, UPPER, HINGE, RIGHT, OPEN, FALSE), this.createSouthUpperRightVariant(path, false));
        variants.put(Map.of(FACING, SOUTH, HALF, UPPER, HINGE, RIGHT, OPEN, TRUE), this.createSouthUpperRightVariant(path, true));
    }

    private Variant createSouthLowerLeftVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX + LEFT_SUFFIX, open, ROTATION_90);
    }

    private Variant createSouthLowerRightVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX + RIGHT_SUFFIX, open, ROTATION_90);
    }

    private Variant createSouthUpperLeftVariant(String path, boolean open) {
        return this.createVariant(path + TOP_SUFFIX + LEFT_SUFFIX, open, ROTATION_90);
    }

    private Variant createSouthUpperRightVariant(String path, boolean open) {
        return this.createVariant(path + TOP_SUFFIX + RIGHT_SUFFIX, open, ROTATION_90);
    }

    private void createWestVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, WEST, HALF, LOWER, HINGE, LEFT, OPEN, FALSE), this.createWestLowerLeftVariant(path, false));
        variants.put(Map.of(FACING, WEST, HALF, LOWER, HINGE, LEFT, OPEN, TRUE), this.createWestLowerLeftVariant(path, true));
        variants.put(Map.of(FACING, WEST, HALF, LOWER, HINGE, RIGHT, OPEN, FALSE), this.createWestLowerRightVariant(path, false));
        variants.put(Map.of(FACING, WEST, HALF, LOWER, HINGE, RIGHT, OPEN, TRUE), this.createWestLowerRightVariant(path, true));
        variants.put(Map.of(FACING, WEST, HALF, UPPER, HINGE, LEFT, OPEN, FALSE), this.createWestUpperLeftVariant(path, false));
        variants.put(Map.of(FACING, WEST, HALF, UPPER, HINGE, LEFT, OPEN, TRUE), this.createWestUpperLeftVariant(path, true));
        variants.put(Map.of(FACING, WEST, HALF, UPPER, HINGE, RIGHT, OPEN, FALSE), this.createWestUpperRightVariant(path, false));
        variants.put(Map.of(FACING, WEST, HALF, UPPER, HINGE, RIGHT, OPEN, TRUE), this.createWestUpperRightVariant(path, true));
    }

    private Variant createWestLowerLeftVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX + LEFT_SUFFIX, open, ROTATION_180);
    }

    private Variant createWestLowerRightVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX + RIGHT_SUFFIX, open, ROTATION_180);
    }

    private Variant createWestUpperLeftVariant(String path, boolean open) {
        return this.createVariant(path + TOP_SUFFIX + LEFT_SUFFIX, open, ROTATION_180);
    }

    private Variant createWestUpperRightVariant(String path, boolean open) {
        return this.createVariant(path + TOP_SUFFIX + RIGHT_SUFFIX, open, ROTATION_180);
    }

    private Variant createVariant(String path, boolean open, Integer y) {
        String resolvedModel = this.resolveModel(path, open);
        return Variant.ofY(resolvedModel, y);
    }

    private String resolveModel(String path, boolean open) {
        return open ? path + OPEN_SUFFIX : path;
    }
}
