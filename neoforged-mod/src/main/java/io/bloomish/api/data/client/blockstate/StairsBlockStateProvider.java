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
public class StairsBlockStateProvider extends AbstractBlockStateProvider {
    private static final String INNER_SUFFIX = "_inner";
    private static final String OUTER_SUFFIX = "_outer";
    private static final String FACING = "facing";
    private static final String HALF = "half";
    private static final String SHAPE = "shape";
    private static final String BOTTOM = "bottom";
    private static final String TOP = "top";
    private static final String INNER_LEFT = "inner_left";
    private static final String INNER_RIGHT = "inner_right";
    private static final String OUTER_LEFT = "outer_left";
    private static final String OUTER_RIGHT = "outer_right";
    private static final String STRAIGHT = "straight";
    private static final String EAST = "east";
    private static final String NORTH = "north";
    private static final String SOUTH = "south";
    private static final String WEST = "west";
    private static final int ROTATION_90 = 90;
    private static final int ROTATION_180 = 180;
    private static final int ROTATION_270 = 270;
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
        Map<Map<String, String>, VariantBlockState.Variant> variants = new HashMap<>();
        this.createEastVariants(path, variants);
        this.createNorthVariants(path, variants);
        this.createSouthVariants(path, variants);
        this.createWestVariants(path, variants);
        return VariantBlockState.of(variants);
    }

    private void createEastVariants(String path, Map<Map<String, String>, VariantBlockState.Variant> variants) {
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, SHAPE, INNER_LEFT), this.createEastBottomInnerLeftVariant(path));
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, SHAPE, INNER_RIGHT), this.createEastBottomInnerRightVariant(path));
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, SHAPE, OUTER_LEFT), this.createEastBottomOuterLeftVariant(path));
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, SHAPE, OUTER_RIGHT), this.createEastBottomOuterRightVariant(path));
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, SHAPE, STRAIGHT), this.createEastBottomStraightVariant(path));
        variants.put(Map.of(FACING, EAST, HALF, TOP, SHAPE, INNER_LEFT), this.createEastTopInnerLeftVariant(path));
        variants.put(Map.of(FACING, EAST, HALF, TOP, SHAPE, INNER_RIGHT), this.createEastTopInnerRightVariant(path));
        variants.put(Map.of(FACING, EAST, HALF, TOP, SHAPE, OUTER_LEFT), this.createEastTopOuterLeftVariant(path));
        variants.put(Map.of(FACING, EAST, HALF, TOP, SHAPE, OUTER_RIGHT), this.createEastTopOuterRightVariant(path));
        variants.put(Map.of(FACING, EAST, HALF, TOP, SHAPE, STRAIGHT), this.createEastTopStraightVariant(path));
    }

    private VariantBlockState.Variant createEastBottomInnerLeftVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, null, ROTATION_270);
    }

    private VariantBlockState.Variant createEastBottomInnerRightVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX);
    }

    private VariantBlockState.Variant createEastBottomOuterLeftVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, null, ROTATION_270);
    }

    private VariantBlockState.Variant createEastBottomOuterRightVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX);
    }

    private VariantBlockState.Variant createEastBottomStraightVariant(String path) {
        return this.createVariant(path);
    }

    private VariantBlockState.Variant createEastTopInnerLeftVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, ROTATION_180, null);
    }

    private VariantBlockState.Variant createEastTopInnerRightVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, ROTATION_180, ROTATION_90);
    }

    private VariantBlockState.Variant createEastTopOuterLeftVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, ROTATION_180, null);
    }

    private VariantBlockState.Variant createEastTopOuterRightVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, ROTATION_180, ROTATION_90);
    }

    private VariantBlockState.Variant createEastTopStraightVariant(String path) {
        return this.createVariant(path, ROTATION_180, null);
    }

    private void createNorthVariants(String path, Map<Map<String, String>, VariantBlockState.Variant> variants) {
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, SHAPE, INNER_LEFT), this.createNorthBottomInnerLeftVariant(path));
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, SHAPE, INNER_RIGHT), this.createNorthBottomInnerRightVariant(path));
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, SHAPE, OUTER_LEFT), this.createNorthBottomOuterLeftVariant(path));
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, SHAPE, OUTER_RIGHT), this.createNorthBottomOuterRightVariant(path));
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, SHAPE, STRAIGHT), this.createNorthBottomStraightVariant(path));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, SHAPE, INNER_LEFT), this.createNorthTopInnerLeftVariant(path));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, SHAPE, INNER_RIGHT), this.createNorthTopInnerRightVariant(path));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, SHAPE, OUTER_LEFT), this.createNorthTopOuterLeftVariant(path));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, SHAPE, OUTER_RIGHT), this.createNorthTopOuterRightVariant(path));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, SHAPE, STRAIGHT), this.createNorthTopStraightVariant(path));
    }

    private VariantBlockState.Variant createNorthBottomInnerLeftVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, null, ROTATION_180);
    }

    private VariantBlockState.Variant createNorthBottomInnerRightVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, null, ROTATION_270);
    }

    private VariantBlockState.Variant createNorthBottomOuterLeftVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, null, ROTATION_180);
    }

    private VariantBlockState.Variant createNorthBottomOuterRightVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, null, ROTATION_270);
    }

    private VariantBlockState.Variant createNorthBottomStraightVariant(String path) {
        return this.createVariant(path, null, ROTATION_270);
    }

    private VariantBlockState.Variant createNorthTopInnerLeftVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, ROTATION_180, ROTATION_270);
    }

    private VariantBlockState.Variant createNorthTopInnerRightVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, ROTATION_180, null);
    }

    private VariantBlockState.Variant createNorthTopOuterLeftVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, ROTATION_180, ROTATION_270);
    }

    private VariantBlockState.Variant createNorthTopOuterRightVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, ROTATION_180, null);
    }

    private VariantBlockState.Variant createNorthTopStraightVariant(String path) {
        return this.createVariant(path, ROTATION_180, ROTATION_270);
    }

    private void createSouthVariants(String path, Map<Map<String, String>, VariantBlockState.Variant> variants) {
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, SHAPE, INNER_LEFT), this.createSouthBottomInnerLeftVariant(path));
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, SHAPE, INNER_RIGHT), this.createSouthBottomInnerRightVariant(path));
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, SHAPE, OUTER_LEFT), this.createSouthBottomOuterLeftVariant(path));
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, SHAPE, OUTER_RIGHT), this.createSouthBottomOuterRightVariant(path));
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, SHAPE, STRAIGHT), this.createSouthBottomStraightVariant(path));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, SHAPE, INNER_LEFT), this.createSouthTopInnerLeftVariant(path));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, SHAPE, INNER_RIGHT), this.createSouthTopInnerRightVariant(path));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, SHAPE, OUTER_LEFT), this.createSouthTopOuterLeftVariant(path));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, SHAPE, OUTER_RIGHT), this.createSouthTopOuterRightVariant(path));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, SHAPE, STRAIGHT), this.createSouthTopStraightVariant(path));
    }

    private VariantBlockState.Variant createSouthBottomInnerLeftVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX);
    }

    private VariantBlockState.Variant createSouthBottomInnerRightVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, null, ROTATION_90);
    }

    private VariantBlockState.Variant createSouthBottomOuterLeftVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX);
    }

    private VariantBlockState.Variant createSouthBottomOuterRightVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, null, ROTATION_90);
    }

    private VariantBlockState.Variant createSouthBottomStraightVariant(String path) {
        return this.createVariant(path, null, ROTATION_90);
    }

    private VariantBlockState.Variant createSouthTopInnerLeftVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, ROTATION_180, ROTATION_90);
    }

    private VariantBlockState.Variant createSouthTopInnerRightVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, ROTATION_180, ROTATION_180);
    }

    private VariantBlockState.Variant createSouthTopOuterLeftVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, ROTATION_180, ROTATION_90);
    }

    private VariantBlockState.Variant createSouthTopOuterRightVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, ROTATION_180, ROTATION_180);
    }

    private VariantBlockState.Variant createSouthTopStraightVariant(String path) {
        return this.createVariant(path, ROTATION_180, ROTATION_90);
    }

    private void createWestVariants(String path, Map<Map<String, String>, VariantBlockState.Variant> variants) {
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, SHAPE, INNER_LEFT), this.createWestBottomInnerLeftVariant(path));
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, SHAPE, INNER_RIGHT), this.createWestBottomInnerRightVariant(path));
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, SHAPE, OUTER_LEFT), this.createWestBottomOuterLeftVariant(path));
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, SHAPE, OUTER_RIGHT), this.createWestBottomOuterRightVariant(path));
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, SHAPE, STRAIGHT), this.createWestBottomStraightVariant(path));
        variants.put(Map.of(FACING, WEST, HALF, TOP, SHAPE, INNER_LEFT), this.createWestTopInnerLeftVariant(path));
        variants.put(Map.of(FACING, WEST, HALF, TOP, SHAPE, INNER_RIGHT), this.createWestTopInnerRightVariant(path));
        variants.put(Map.of(FACING, WEST, HALF, TOP, SHAPE, OUTER_LEFT), this.createWestTopOuterLeftVariant(path));
        variants.put(Map.of(FACING, WEST, HALF, TOP, SHAPE, OUTER_RIGHT), this.createWestTopOuterRightVariant(path));
        variants.put(Map.of(FACING, WEST, HALF, TOP, SHAPE, STRAIGHT), this.createWestTopStraightVariant(path));
    }

    private VariantBlockState.Variant createWestBottomInnerLeftVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, null, ROTATION_90);
    }

    private VariantBlockState.Variant createWestBottomInnerRightVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, null, ROTATION_180);
    }

    private VariantBlockState.Variant createWestBottomOuterLeftVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, null, ROTATION_90);
    }

    private VariantBlockState.Variant createWestBottomOuterRightVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, null, ROTATION_180);
    }

    private VariantBlockState.Variant createWestBottomStraightVariant(String path) {
        return this.createVariant(path, null, ROTATION_180);
    }

    private VariantBlockState.Variant createWestTopInnerLeftVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, ROTATION_180, ROTATION_180);
    }

    private VariantBlockState.Variant createWestTopInnerRightVariant(String path) {
        return this.createVariant(path + INNER_SUFFIX, ROTATION_180, ROTATION_270);
    }

    private VariantBlockState.Variant createWestTopOuterLeftVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, ROTATION_180, ROTATION_180);
    }

    private VariantBlockState.Variant createWestTopOuterRightVariant(String path) {
        return this.createVariant(path + OUTER_SUFFIX, ROTATION_180, ROTATION_270);
    }

    private VariantBlockState.Variant createWestTopStraightVariant(String path) {
        return this.createVariant(path, ROTATION_180, ROTATION_180);
    }

    private VariantBlockState.Variant createVariant(String model) {
        return VariantBlockState.Variant.of(model);
    }

    private VariantBlockState.Variant createVariant(String model, Integer x, Integer y) {
        return new VariantBlockState.Variant(model, true, x, y);
    }
}