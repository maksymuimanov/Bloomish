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
public class TrapdoorBlockStateProvider extends AbstractBlockStateProvider {
    private static final String BOTTOM_SUFFIX = "_bottom";
    private static final String TOP_SUFFIX = "_top";
    private static final String OPEN_SUFFIX = "_open";
    private static final String FACING = "facing";
    private static final String HALF = "half";
    private static final String OPEN = "open";
    private static final String BOTTOM = "bottom";
    private static final String TOP = "top";
    private static final String EAST = "east";
    private static final String NORTH = "north";
    private static final String SOUTH = "south";
    private static final String WEST = "west";
    private static final String TRUE = "true";
    private static final String FALSE = "false";
    private final ValueChannelBus channelBus;

    public TrapdoorBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_TRAPDOOR_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createTrapdoorBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private VariantBlockState createTrapdoorBlockState(String path) {
        Map<Map<String, String>, Variant> variants = new HashMap<>();
        this.createEastVariants(path, variants);
        this.createNorthVariants(path, variants);
        this.createSouthVariants(path, variants);
        this.createWestVariants(path, variants);
        return VariantBlockState.of(variants);
    }

    private void createEastVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, OPEN, FALSE), Variant.ofY90(this.bottomModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, OPEN, TRUE), Variant.ofY90(this.openBottomModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, TOP, OPEN, FALSE), Variant.ofY90(this.topModel(path)));
        variants.put(Map.of(FACING, EAST, HALF, TOP, OPEN, TRUE), Variant.ofX180Y270(this.openModel(path)));
    }

    private void createNorthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, OPEN, FALSE), Variant.ofModel(this.bottomModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, OPEN, TRUE), Variant.ofModel(this.openBottomModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, OPEN, FALSE), Variant.ofModel(this.topModel(path)));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, OPEN, TRUE), Variant.ofX180Y180(this.openModel(path)));
    }

    private void createSouthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, OPEN, FALSE), Variant.ofY180(this.bottomModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, OPEN, TRUE), Variant.ofY180(this.openBottomModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, OPEN, FALSE), Variant.ofY180(this.topModel(path)));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, OPEN, TRUE), Variant.ofX180Y0(this.openModel(path)));
    }

    private void createWestVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, OPEN, FALSE), Variant.ofY270(this.bottomModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, OPEN, TRUE), Variant.ofY270(this.openBottomModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, TOP, OPEN, FALSE), Variant.ofY270(this.topModel(path)));
        variants.put(Map.of(FACING, WEST, HALF, TOP, OPEN, TRUE), Variant.ofX180Y90(this.openModel(path)));
    }

    private String bottomModel(String path) {
        return path + BOTTOM_SUFFIX;
    }

    private String openBottomModel(String path) {
        return this.openModel(path) + BOTTOM_SUFFIX;
    }

    private String openModel(String path) {
        return path + OPEN_SUFFIX;
    }

    private String topModel(String path) {
        return path + TOP_SUFFIX;
    }
}