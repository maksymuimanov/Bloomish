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
public class ButtonBlockStateProvider extends AbstractBlockStateProvider {
    private static final String PRESSED_SUFFIX = "_pressed";
    private static final String FACE = "face";
    private static final String FACING = "facing";
    private static final String POWERED = "powered";
    private static final String CEILING = "ceiling";
    private static final String FLOOR = "floor";
    private static final String WALL = "wall";
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

    public ButtonBlockStateProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<Holder<? extends Block>>forEachDrain(DataChannels.BLOCK_STATE_PROVIDER_BUTTON_BLOCKS, holder -> {
            Block block = holder.value();
            String path = this.blockPath(block);
            BlockState blockState = this.createButtonBlockState(path);
            this.addBlockState(block, blockState);
        });
    }

    private VariantBlockState createButtonBlockState(String path) {
        Map<Map<String, String>, VariantBlockState.Variant> variants = new HashMap<>();
        this.createCeilingVariants(path, variants);
        this.createFloorVariants(path, variants);
        this.createWallVariants(path, variants);
        return VariantBlockState.of(variants);
    }

    private void createCeilingVariants(String path, Map<Map<String, String>, VariantBlockState.Variant> variants) {
        variants.put(Map.of(FACE, CEILING, FACING, EAST, POWERED, FALSE), this.createCeilingEastVariant(path, false));
        variants.put(Map.of(FACE, CEILING, FACING, EAST, POWERED, TRUE), this.createCeilingEastVariant(path, true));
        variants.put(Map.of(FACE, CEILING, FACING, NORTH, POWERED, FALSE), this.createCeilingNorthVariant(path, false));
        variants.put(Map.of(FACE, CEILING, FACING, NORTH, POWERED, TRUE), this.createCeilingNorthVariant(path, true));
        variants.put(Map.of(FACE, CEILING, FACING, SOUTH, POWERED, FALSE), this.createCeilingSouthVariant(path, false));
        variants.put(Map.of(FACE, CEILING, FACING, SOUTH, POWERED, TRUE), this.createCeilingSouthVariant(path, true));
        variants.put(Map.of(FACE, CEILING, FACING, WEST, POWERED, FALSE), this.createCeilingWestVariant(path, false));
        variants.put(Map.of(FACE, CEILING, FACING, WEST, POWERED, TRUE), this.createCeilingWestVariant(path, true));
    }

    private VariantBlockState.Variant createCeilingEastVariant(String path, boolean powered) {
        return this.createVariant(path, powered, ROTATION_180, ROTATION_270);
    }

    private VariantBlockState.Variant createCeilingNorthVariant(String path, boolean powered) {
        return this.createVariant(path, powered, ROTATION_180, ROTATION_180);
    }

    private VariantBlockState.Variant createCeilingSouthVariant(String path, boolean powered) {
        return this.createVariant(path, powered, ROTATION_180);
    }

    private VariantBlockState.Variant createCeilingWestVariant(String path, boolean powered) {
        return this.createVariant(path, powered, ROTATION_180, ROTATION_90);
    }

    private void createFloorVariants(String path, Map<Map<String, String>, VariantBlockState.Variant> variants) {
        variants.put(Map.of(FACE, FLOOR, FACING, EAST, POWERED, FALSE), this.createFloorEastVariant(path, false));
        variants.put(Map.of(FACE, FLOOR, FACING, EAST, POWERED, TRUE), this.createFloorEastVariant(path, true));
        variants.put(Map.of(FACE, FLOOR, FACING, NORTH, POWERED, FALSE), this.createFloorNorthVariant(path, false));
        variants.put(Map.of(FACE, FLOOR, FACING, NORTH, POWERED, TRUE), this.createFloorNorthVariant(path, true));
        variants.put(Map.of(FACE, FLOOR, FACING, SOUTH, POWERED, FALSE), this.createFloorSouthVariant(path, false));
        variants.put(Map.of(FACE, FLOOR, FACING, SOUTH, POWERED, TRUE), this.createFloorSouthVariant(path, true));
        variants.put(Map.of(FACE, FLOOR, FACING, WEST, POWERED, FALSE), this.createFloorWestVariant(path, false));
        variants.put(Map.of(FACE, FLOOR, FACING, WEST, POWERED, TRUE), this.createFloorWestVariant(path, true));
    }

    private VariantBlockState.Variant createFloorEastVariant(String path, boolean powered) {
        return this.createVariant(path, powered, null, ROTATION_90);
    }

    private VariantBlockState.Variant createFloorNorthVariant(String path, boolean powered) {
        return this.createVariant(path, powered);
    }

    private VariantBlockState.Variant createFloorSouthVariant(String path, boolean powered) {
        return this.createVariant(path, powered, null, ROTATION_180);
    }

    private VariantBlockState.Variant createFloorWestVariant(String path, boolean powered) {
        return this.createVariant(path, powered, null, ROTATION_270);
    }

    private void createWallVariants(String path, Map<Map<String, String>, VariantBlockState.Variant> variants) {
        variants.put(Map.of(FACE, WALL, FACING, EAST, POWERED, FALSE), this.createWallEastVariant(path, false));
        variants.put(Map.of(FACE, WALL, FACING, EAST, POWERED, TRUE), this.createWallEastVariant(path, true));
        variants.put(Map.of(FACE, WALL, FACING, NORTH, POWERED, FALSE), this.createWallNorthVariant(path, false));
        variants.put(Map.of(FACE, WALL, FACING, NORTH, POWERED, TRUE), this.createWallNorthVariant(path, true));
        variants.put(Map.of(FACE, WALL, FACING, SOUTH, POWERED, FALSE), this.createWallSouthVariant(path, false));
        variants.put(Map.of(FACE, WALL, FACING, SOUTH, POWERED, TRUE), this.createWallSouthVariant(path, true));
        variants.put(Map.of(FACE, WALL, FACING, WEST, POWERED, FALSE), this.createWallWestVariant(path, false));
        variants.put(Map.of(FACE, WALL, FACING, WEST, POWERED, TRUE), this.createWallWestVariant(path, true));
    }

    private VariantBlockState.Variant createWallEastVariant(String path, boolean powered) {
        return this.createVariant(path, powered, ROTATION_90, ROTATION_90, true);
    }

    private VariantBlockState.Variant createWallNorthVariant(String path, boolean powered) {
        return this.createVariant(path, powered, ROTATION_90, null, true);
    }

    private VariantBlockState.Variant createWallSouthVariant(String path, boolean powered) {
        return this.createVariant(path, powered, ROTATION_90, ROTATION_180, true);
    }

    private VariantBlockState.Variant createWallWestVariant(String path, boolean powered) {
        return this.createVariant(path, powered, ROTATION_90, ROTATION_270, true);
    }

    private VariantBlockState.Variant createVariant(String path, boolean powered) {
        return this.createVariant(path, powered, null, null, false);
    }

    private VariantBlockState.Variant createVariant(String path, boolean powered, Integer x) {
        return this.createVariant(path, powered, x, null, false);
    }

    private VariantBlockState.Variant createVariant(String path, boolean powered, Integer x, Integer y) {
        return this.createVariant(path, powered, x, y, false);
    }

    private VariantBlockState.Variant createVariant(String path, boolean powered, Integer x, Integer y, boolean uvlock) {
        String model = powered ? path + PRESSED_SUFFIX : path;
        return new VariantBlockState.Variant(model, uvlock ? true : null, x, y);
    }
}