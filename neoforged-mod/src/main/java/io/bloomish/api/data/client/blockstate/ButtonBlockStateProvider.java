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
        Map<Map<String, String>, Variant> variants = new HashMap<>();
        this.createCeilingVariants(path, variants);
        this.createFloorVariants(path, variants);
        this.createWallVariants(path, variants);
        return VariantBlockState.of(variants);
    }

    private void createCeilingVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACE, CEILING, FACING, EAST, POWERED, FALSE), this.createCeilingEastVariant(path, false));
        variants.put(Map.of(FACE, CEILING, FACING, EAST, POWERED, TRUE), this.createCeilingEastVariant(path, true));
        variants.put(Map.of(FACE, CEILING, FACING, NORTH, POWERED, FALSE), this.createCeilingNorthVariant(path, false));
        variants.put(Map.of(FACE, CEILING, FACING, NORTH, POWERED, TRUE), this.createCeilingNorthVariant(path, true));
        variants.put(Map.of(FACE, CEILING, FACING, SOUTH, POWERED, FALSE), this.createCeilingSouthVariant(path, false));
        variants.put(Map.of(FACE, CEILING, FACING, SOUTH, POWERED, TRUE), this.createCeilingSouthVariant(path, true));
        variants.put(Map.of(FACE, CEILING, FACING, WEST, POWERED, FALSE), this.createCeilingWestVariant(path, false));
        variants.put(Map.of(FACE, CEILING, FACING, WEST, POWERED, TRUE), this.createCeilingWestVariant(path, true));
    }

    private Variant createCeilingEastVariant(String path, boolean powered) {
        return new Variant(this.resolveModel(path, powered), ROTATION_180, ROTATION_270);
    }

    private Variant createCeilingNorthVariant(String path, boolean powered) {
        return new Variant(this.resolveModel(path, powered), ROTATION_180, ROTATION_180);
    }

    private Variant createCeilingSouthVariant(String path, boolean powered) {
        return Variant.ofX(this.resolveModel(path, powered), ROTATION_180);
    }

    private Variant createCeilingWestVariant(String path, boolean powered) {
        return new Variant(this.resolveModel(path, powered), ROTATION_180, ROTATION_90);
    }

    private void createFloorVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACE, FLOOR, FACING, EAST, POWERED, FALSE), this.createFloorEastVariant(path, false));
        variants.put(Map.of(FACE, FLOOR, FACING, EAST, POWERED, TRUE), this.createFloorEastVariant(path, true));
        variants.put(Map.of(FACE, FLOOR, FACING, NORTH, POWERED, FALSE), this.createFloorNorthVariant(path, false));
        variants.put(Map.of(FACE, FLOOR, FACING, NORTH, POWERED, TRUE), this.createFloorNorthVariant(path, true));
        variants.put(Map.of(FACE, FLOOR, FACING, SOUTH, POWERED, FALSE), this.createFloorSouthVariant(path, false));
        variants.put(Map.of(FACE, FLOOR, FACING, SOUTH, POWERED, TRUE), this.createFloorSouthVariant(path, true));
        variants.put(Map.of(FACE, FLOOR, FACING, WEST, POWERED, FALSE), this.createFloorWestVariant(path, false));
        variants.put(Map.of(FACE, FLOOR, FACING, WEST, POWERED, TRUE), this.createFloorWestVariant(path, true));
    }

    private Variant createFloorEastVariant(String path, boolean powered) {
        return Variant.ofY(this.resolveModel(path, powered), ROTATION_90);
    }

    private Variant createFloorNorthVariant(String path, boolean powered) {
        return new Variant(this.resolveModel(path, powered));
    }

    private Variant createFloorSouthVariant(String path, boolean powered) {
        return Variant.ofY(this.resolveModel(path, powered), ROTATION_180);
    }

    private Variant createFloorWestVariant(String path, boolean powered) {
        return Variant.ofY(this.resolveModel(path, powered), ROTATION_270);
    }

    private void createWallVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACE, WALL, FACING, EAST, POWERED, FALSE), this.createWallEastVariant(path, false));
        variants.put(Map.of(FACE, WALL, FACING, EAST, POWERED, TRUE), this.createWallEastVariant(path, true));
        variants.put(Map.of(FACE, WALL, FACING, NORTH, POWERED, FALSE), this.createWallNorthVariant(path, false));
        variants.put(Map.of(FACE, WALL, FACING, NORTH, POWERED, TRUE), this.createWallNorthVariant(path, true));
        variants.put(Map.of(FACE, WALL, FACING, SOUTH, POWERED, FALSE), this.createWallSouthVariant(path, false));
        variants.put(Map.of(FACE, WALL, FACING, SOUTH, POWERED, TRUE), this.createWallSouthVariant(path, true));
        variants.put(Map.of(FACE, WALL, FACING, WEST, POWERED, FALSE), this.createWallWestVariant(path, false));
        variants.put(Map.of(FACE, WALL, FACING, WEST, POWERED, TRUE), this.createWallWestVariant(path, true));
    }

    private Variant createWallEastVariant(String path, boolean powered) {
        return Variant.ofUvlock(this.resolveModel(path, powered), ROTATION_90, ROTATION_90);
    }

    private Variant createWallNorthVariant(String path, boolean powered) {
        return Variant.ofUvlockX(this.resolveModel(path, powered), ROTATION_90);
    }

    private Variant createWallSouthVariant(String path, boolean powered) {
        return Variant.ofUvlock(this.resolveModel(path, powered), ROTATION_90, ROTATION_180);
    }

    private Variant createWallWestVariant(String path, boolean powered) {
        return Variant.ofUvlock(this.resolveModel(path, powered), ROTATION_90, ROTATION_270);
    }

    private String resolveModel(String path, boolean powered) {
        return powered ? path + PRESSED_SUFFIX : path;
    }
}