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
        variants.put(Map.of(FACING, EAST, IN_WALL, FALSE, OPEN, FALSE), this.createEastVariant(path, false, false));
        variants.put(Map.of(FACING, EAST, IN_WALL, FALSE, OPEN, TRUE), this.createEastVariant(path, false, true));
        variants.put(Map.of(FACING, EAST, IN_WALL, TRUE, OPEN, FALSE), this.createEastVariant(path, true, false));
        variants.put(Map.of(FACING, EAST, IN_WALL, TRUE, OPEN, TRUE), this.createEastVariant(path, true, true));
    }

    private Variant createEastVariant(String path, boolean inWall, boolean open) {
        return this.createVariant(path + (inWall ? WALL_SUFFIX : ""), open, ROTATION_270);
    }

    private void createNorthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, NORTH, IN_WALL, FALSE, OPEN, FALSE), this.createNorthVariant(path, false, false));
        variants.put(Map.of(FACING, NORTH, IN_WALL, FALSE, OPEN, TRUE), this.createNorthVariant(path, false, true));
        variants.put(Map.of(FACING, NORTH, IN_WALL, TRUE, OPEN, FALSE), this.createNorthVariant(path, true, false));
        variants.put(Map.of(FACING, NORTH, IN_WALL, TRUE, OPEN, TRUE), this.createNorthVariant(path, true, true));
    }

    private Variant createNorthVariant(String path, boolean inWall, boolean open) {
        return this.createVariant(path + (inWall ? WALL_SUFFIX : ""), open, ROTATION_180);
    }

    private void createSouthVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, SOUTH, IN_WALL, FALSE, OPEN, FALSE), this.createSouthVariant(path, false, false));
        variants.put(Map.of(FACING, SOUTH, IN_WALL, FALSE, OPEN, TRUE), this.createSouthVariant(path, false, true));
        variants.put(Map.of(FACING, SOUTH, IN_WALL, TRUE, OPEN, FALSE), this.createSouthVariant(path, true, false));
        variants.put(Map.of(FACING, SOUTH, IN_WALL, TRUE, OPEN, TRUE), this.createSouthVariant(path, true, true));
    }

    private Variant createSouthVariant(String path, boolean inWall, boolean open) {
        return this.createVariant(path + (inWall ? WALL_SUFFIX : ""), open);
    }

    private void createWestVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACING, WEST, IN_WALL, FALSE, OPEN, FALSE), this.createWestVariant(path, false, false));
        variants.put(Map.of(FACING, WEST, IN_WALL, FALSE, OPEN, TRUE), this.createWestVariant(path, false, true));
        variants.put(Map.of(FACING, WEST, IN_WALL, TRUE, OPEN, FALSE), this.createWestVariant(path, true, false));
        variants.put(Map.of(FACING, WEST, IN_WALL, TRUE, OPEN, TRUE), this.createWestVariant(path, true, true));
    }

    private Variant createWestVariant(String path, boolean inWall, boolean open) {
        return this.createVariant(path + (inWall ? WALL_SUFFIX : ""), open, ROTATION_90);
    }

    private Variant createVariant(String model, boolean open) {
        return this.createVariant(model, open, null);
    }

    private Variant createVariant(String model, boolean open, Integer y) {
        String resolvedModel = open ? model + OPEN_SUFFIX : model;
        return new Variant(resolvedModel, true, null, y);
    }
}
