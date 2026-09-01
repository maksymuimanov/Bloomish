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
    private static final int ROTATION_90 = 90;
    private static final int ROTATION_180 = 180;
    private static final int ROTATION_270 = 270;
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
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, OPEN, FALSE), this.createEastBottomVariant(path, false));
        variants.put(Map.of(FACING, EAST, HALF, BOTTOM, OPEN, TRUE), this.createEastBottomVariant(path, true));
        variants.put(Map.of(FACING, EAST, HALF, TOP, OPEN, FALSE), this.createEastTopVariant(path, false));
        variants.put(Map.of(FACING, EAST, HALF, TOP, OPEN, TRUE), this.createEastTopVariant(path, true));
    }

    private Variant createEastBottomVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX, open, null, ROTATION_90);
    }

    private Variant createEastTopVariant(String path, boolean open) {
        return open
                ? this.createVariant(path, true, ROTATION_180, ROTATION_270)
                : this.createVariant(path + TOP_SUFFIX, false, null, ROTATION_90);
    }

    private void createNorthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, OPEN, FALSE), this.createNorthBottomVariant(path, false));
        variants.put(Map.of(FACING, NORTH, HALF, BOTTOM, OPEN, TRUE), this.createNorthBottomVariant(path, true));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, OPEN, FALSE), this.createNorthTopVariant(path, false));
        variants.put(Map.of(FACING, NORTH, HALF, TOP, OPEN, TRUE), this.createNorthTopVariant(path, true));
    }

    private Variant createNorthBottomVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX, open);
    }

    private Variant createNorthTopVariant(String path, boolean open) {
        return open
                ? this.createVariant(path, true, ROTATION_180, ROTATION_180)
                : this.createVariant(path + TOP_SUFFIX, false);
    }

    private void createSouthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, OPEN, FALSE), this.createSouthBottomVariant(path, false));
        variants.put(Map.of(FACING, SOUTH, HALF, BOTTOM, OPEN, TRUE), this.createSouthBottomVariant(path, true));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, OPEN, FALSE), this.createSouthTopVariant(path, false));
        variants.put(Map.of(FACING, SOUTH, HALF, TOP, OPEN, TRUE), this.createSouthTopVariant(path, true));
    }

    private Variant createSouthBottomVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX, open, null, ROTATION_180);
    }

    private Variant createSouthTopVariant(String path, boolean open) {
        return open
                ? this.createVariant(path, true, ROTATION_180, 0)
                : this.createVariant(path + TOP_SUFFIX, false, null, ROTATION_180);
    }

    private void createWestVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, OPEN, FALSE), this.createWestBottomVariant(path, false));
        variants.put(Map.of(FACING, WEST, HALF, BOTTOM, OPEN, TRUE), this.createWestBottomVariant(path, true));
        variants.put(Map.of(FACING, WEST, HALF, TOP, OPEN, FALSE), this.createWestTopVariant(path, false));
        variants.put(Map.of(FACING, WEST, HALF, TOP, OPEN, TRUE), this.createWestTopVariant(path, true));
    }

    private Variant createWestBottomVariant(String path, boolean open) {
        return this.createVariant(path + BOTTOM_SUFFIX, open, null, ROTATION_270);
    }

    private Variant createWestTopVariant(String path, boolean open) {
        return open
                ? this.createVariant(path, true, ROTATION_180, ROTATION_90)
                : this.createVariant(path + TOP_SUFFIX, false, null, ROTATION_270);
    }

    private Variant createVariant(String path, boolean open) {
        return this.createVariant(path, open, null, null);
    }

    private Variant createVariant(String path, boolean open, Integer x, Integer y) {
        String model = open ? path + OPEN_SUFFIX : path;
        return new Variant(model, x, y);
    }
}