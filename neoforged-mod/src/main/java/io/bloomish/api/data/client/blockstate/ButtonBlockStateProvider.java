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
        variants.put(Map.of(FACE, CEILING, FACING, EAST, POWERED, FALSE), Variant.ofXY(path, ROTATION_180, ROTATION_270));
        variants.put(Map.of(FACE, CEILING, FACING, EAST, POWERED, TRUE), Variant.ofXY(this.pressedModel(path), ROTATION_180, ROTATION_270));
        variants.put(Map.of(FACE, CEILING, FACING, NORTH, POWERED, FALSE), Variant.ofXY(path, ROTATION_180, ROTATION_180));
        variants.put(Map.of(FACE, CEILING, FACING, NORTH, POWERED, TRUE), Variant.ofXY(this.pressedModel(path), ROTATION_180, ROTATION_180));
        variants.put(Map.of(FACE, CEILING, FACING, SOUTH, POWERED, FALSE), Variant.ofX(path, ROTATION_180));
        variants.put(Map.of(FACE, CEILING, FACING, SOUTH, POWERED, TRUE), Variant.ofX(this.pressedModel(path), ROTATION_180));
        variants.put(Map.of(FACE, CEILING, FACING, WEST, POWERED, FALSE), Variant.ofXY(path, ROTATION_180, ROTATION_90));
        variants.put(Map.of(FACE, CEILING, FACING, WEST, POWERED, TRUE), Variant.ofXY(this.pressedModel(path), ROTATION_180, ROTATION_90));
    }

    private void createFloorVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACE, FLOOR, FACING, EAST, POWERED, FALSE), Variant.ofY(path, ROTATION_90));
        variants.put(Map.of(FACE, FLOOR, FACING, EAST, POWERED, TRUE), Variant.ofY(this.pressedModel(path), ROTATION_90));
        variants.put(Map.of(FACE, FLOOR, FACING, NORTH, POWERED, FALSE), Variant.ofModel(path));
        variants.put(Map.of(FACE, FLOOR, FACING, NORTH, POWERED, TRUE), Variant.ofModel(this.pressedModel(path)));
        variants.put(Map.of(FACE, FLOOR, FACING, SOUTH, POWERED, FALSE), Variant.ofY(path, ROTATION_180));
        variants.put(Map.of(FACE, FLOOR, FACING, SOUTH, POWERED, TRUE), Variant.ofY(this.pressedModel(path), ROTATION_180));
        variants.put(Map.of(FACE, FLOOR, FACING, WEST, POWERED, FALSE), Variant.ofY(path, ROTATION_270));
        variants.put(Map.of(FACE, FLOOR, FACING, WEST, POWERED, TRUE), Variant.ofY(this.pressedModel(path), ROTATION_270));
    }

    private void createWallVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACE, WALL, FACING, EAST, POWERED, FALSE), Variant.ofUvlockXY(path, ROTATION_90, ROTATION_90));
        variants.put(Map.of(FACE, WALL, FACING, EAST, POWERED, TRUE), Variant.ofUvlockXY(this.pressedModel(path), ROTATION_90, ROTATION_90));
        variants.put(Map.of(FACE, WALL, FACING, NORTH, POWERED, FALSE), Variant.ofUvlockX(path, ROTATION_90));
        variants.put(Map.of(FACE, WALL, FACING, NORTH, POWERED, TRUE), Variant.ofUvlockX(this.pressedModel(path), ROTATION_90));
        variants.put(Map.of(FACE, WALL, FACING, SOUTH, POWERED, FALSE), Variant.ofUvlockXY(path, ROTATION_90, ROTATION_180));
        variants.put(Map.of(FACE, WALL, FACING, SOUTH, POWERED, TRUE), Variant.ofUvlockXY(this.pressedModel(path), ROTATION_90, ROTATION_180));
        variants.put(Map.of(FACE, WALL, FACING, WEST, POWERED, FALSE), Variant.ofUvlockXY(path, ROTATION_90, ROTATION_270));
        variants.put(Map.of(FACE, WALL, FACING, WEST, POWERED, TRUE), Variant.ofUvlockXY(this.pressedModel(path), ROTATION_90, ROTATION_270));
    }

    private String pressedModel(String path) {
        return path + PRESSED_SUFFIX;
    }
}