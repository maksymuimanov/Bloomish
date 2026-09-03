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
        Map<Map<String, String>, Variant> variants = new HashMap<>();
        this.createEastVariants(path, variants);
        this.createNorthVariants(path, variants);
        this.createSouthVariants(path, variants);
        this.createWestVariants(path, variants);
        return VariantBlockState.of(variants);
    }

    private void createEastVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, SHAPE, INNER_LEFT), Variant.ofUvlockY270(this.innerModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, SHAPE, INNER_RIGHT), Variant.ofModel(this.innerModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, SHAPE, OUTER_LEFT), Variant.ofUvlockY270(this.outerModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, SHAPE, OUTER_RIGHT), Variant.ofModel(this.outerModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, SHAPE, STRAIGHT), Variant.ofModel(this.straightModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, TOP, SHAPE, INNER_LEFT), Variant.ofUvlockX180(this.innerModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, TOP, SHAPE, INNER_RIGHT), Variant.ofX180Y90(this.innerModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, TOP, SHAPE, OUTER_LEFT), Variant.ofUvlockX180(this.outerModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, TOP, SHAPE, OUTER_RIGHT), Variant.ofX180Y90(this.outerModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, TOP, SHAPE, STRAIGHT), Variant.ofUvlockX180(this.straightModel(path)));
    }

    private void createNorthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, SHAPE, INNER_LEFT), Variant.ofUvlockY180(this.innerModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, SHAPE, INNER_RIGHT), Variant.ofUvlockY270(this.innerModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, SHAPE, OUTER_LEFT), Variant.ofUvlockY180(this.outerModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, SHAPE, OUTER_RIGHT), Variant.ofUvlockY270(this.outerModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, SHAPE, STRAIGHT), Variant.ofUvlockY270(this.straightModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, SHAPE, INNER_LEFT), Variant.ofX180Y270(this.innerModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, SHAPE, INNER_RIGHT), Variant.ofUvlockX180(this.innerModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, SHAPE, OUTER_LEFT), Variant.ofX180Y270(this.outerModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, SHAPE, OUTER_RIGHT), Variant.ofUvlockX180(this.outerModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, SHAPE, STRAIGHT), Variant.ofX180Y270(this.straightModel(path)));
    }

    private void createSouthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, SHAPE, INNER_LEFT), Variant.ofModel(this.innerModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, SHAPE, INNER_RIGHT), Variant.ofUvlockY90(this.innerModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, SHAPE, OUTER_LEFT), Variant.ofModel(this.outerModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, SHAPE, OUTER_RIGHT), Variant.ofUvlockY90(this.outerModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, SHAPE, STRAIGHT), Variant.ofUvlockY90(this.straightModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, SHAPE, INNER_LEFT), Variant.ofX180Y90(this.innerModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, SHAPE, INNER_RIGHT), Variant.ofX180Y180(this.innerModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, SHAPE, OUTER_LEFT), Variant.ofX180Y90(this.outerModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, SHAPE, OUTER_RIGHT), Variant.ofX180Y180(this.outerModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, SHAPE, STRAIGHT), Variant.ofX180Y90(this.straightModel(path)));
    }

    private void createWestVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, SHAPE, INNER_LEFT), Variant.ofUvlockY90(this.innerModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, SHAPE, INNER_RIGHT), Variant.ofUvlockY180(this.innerModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, SHAPE, OUTER_LEFT), Variant.ofUvlockY90(this.outerModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, SHAPE, OUTER_RIGHT), Variant.ofUvlockY180(this.outerModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, SHAPE, STRAIGHT), Variant.ofUvlockY180(this.straightModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, TOP, SHAPE, INNER_LEFT), Variant.ofX180Y180(this.innerModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, TOP, SHAPE, INNER_RIGHT), Variant.ofX180Y270(this.innerModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, TOP, SHAPE, OUTER_LEFT), Variant.ofX180Y180(this.outerModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, TOP, SHAPE, OUTER_RIGHT), Variant.ofX180Y270(this.outerModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, TOP, SHAPE, STRAIGHT), Variant.ofX180Y180(this.straightModel(path)));
    }

    private String innerModel(String path) {
        return path + INNER_SUFFIX;
    }

    private String outerModel(String path) {
        return path + OUTER_SUFFIX;
    }

    private String straightModel(String path) {
        return path;
    }
}