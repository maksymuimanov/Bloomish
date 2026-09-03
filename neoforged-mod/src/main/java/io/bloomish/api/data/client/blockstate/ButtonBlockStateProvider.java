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
        variants.put(Map.of(FACE, CEILING, FACING, EAST, POWERED, FALSE), Variant.ofX180Y270(path));
        variants.put(Map.of(FACE, CEILING, FACING, EAST, POWERED, TRUE), Variant.ofX180Y270(this.pressedModel(path)));
        variants.put(Map.of(FACE, CEILING, FACING, NORTH, POWERED, FALSE), Variant.ofX180Y180(path));
        variants.put(Map.of(FACE, CEILING, FACING, NORTH, POWERED, TRUE), Variant.ofX180Y180(this.pressedModel(path)));
        variants.put(Map.of(FACE, CEILING, FACING, SOUTH, POWERED, FALSE), Variant.ofX180(path));
        variants.put(Map.of(FACE, CEILING, FACING, SOUTH, POWERED, TRUE), Variant.ofX180(this.pressedModel(path)));
        variants.put(Map.of(FACE, CEILING, FACING, WEST, POWERED, FALSE), Variant.ofX180Y90(path));
        variants.put(Map.of(FACE, CEILING, FACING, WEST, POWERED, TRUE), Variant.ofX180Y90(this.pressedModel(path)));
    }

    private void createFloorVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACE, FLOOR, FACING, EAST, POWERED, FALSE), Variant.ofY90(path));
        variants.put(Map.of(FACE, FLOOR, FACING, EAST, POWERED, TRUE), Variant.ofY90(this.pressedModel(path)));
        variants.put(Map.of(FACE, FLOOR, FACING, NORTH, POWERED, FALSE), Variant.ofModel(path));
        variants.put(Map.of(FACE, FLOOR, FACING, NORTH, POWERED, TRUE), Variant.ofModel(this.pressedModel(path)));
        variants.put(Map.of(FACE, FLOOR, FACING, SOUTH, POWERED, FALSE), Variant.ofY180(path));
        variants.put(Map.of(FACE, FLOOR, FACING, SOUTH, POWERED, TRUE), Variant.ofY180(this.pressedModel(path)));
        variants.put(Map.of(FACE, FLOOR, FACING, WEST, POWERED, FALSE), Variant.ofY270(path));
        variants.put(Map.of(FACE, FLOOR, FACING, WEST, POWERED, TRUE), Variant.ofY270(this.pressedModel(path)));
    }

    private void createWallVariants(String path, Map<Map<String, String>, Variant> variants) {
        variants.put(Map.of(FACE, WALL, FACING, EAST, POWERED, FALSE), Variant.ofUvlockX90Y90(path));
        variants.put(Map.of(FACE, WALL, FACING, EAST, POWERED, TRUE), Variant.ofUvlockX90Y90(this.pressedModel(path)));
        variants.put(Map.of(FACE, WALL, FACING, NORTH, POWERED, FALSE), Variant.ofUvlockX90(path));
        variants.put(Map.of(FACE, WALL, FACING, NORTH, POWERED, TRUE), Variant.ofUvlockX90(this.pressedModel(path)));
        variants.put(Map.of(FACE, WALL, FACING, SOUTH, POWERED, FALSE), Variant.ofUvlockX90Y180(path));
        variants.put(Map.of(FACE, WALL, FACING, SOUTH, POWERED, TRUE), Variant.ofUvlockX90Y180(this.pressedModel(path)));
        variants.put(Map.of(FACE, WALL, FACING, WEST, POWERED, FALSE), Variant.ofUvlockX90Y270(path));
        variants.put(Map.of(FACE, WALL, FACING, WEST, POWERED, TRUE), Variant.ofUvlockX90Y270(this.pressedModel(path)));
    }

    private String pressedModel(String path) {
        return path + PRESSED_SUFFIX;
    }
}