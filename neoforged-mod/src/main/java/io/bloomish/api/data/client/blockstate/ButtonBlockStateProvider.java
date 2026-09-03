package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.blockstate.property.EnumBlockStateProperty;
import io.bloomish.api.data.client.blockstate.property.Facing;
import io.bloomish.api.data.client.blockstate.property.Powered;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.StringUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

@Injected
public class ButtonBlockStateProvider extends AbstractBlockStateProvider {
    private static final String PRESSED_SUFFIX = "pressed";
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
        return VariantBlockState.ofConditionalVariants(
                ConditionalVariant.of(Variant.ofX180Y270(path), Face.CEILING, Facing.EAST, Powered.FALSE),
                ConditionalVariant.of(Variant.ofX180Y270(this.pressedModel(path)), Face.CEILING, Facing.EAST, Powered.TRUE),
                ConditionalVariant.of(Variant.ofX180Y180(path), Face.CEILING, Facing.NORTH, Powered.FALSE),
                ConditionalVariant.of(Variant.ofX180Y180(this.pressedModel(path)), Face.CEILING, Facing.NORTH, Powered.TRUE),
                ConditionalVariant.of(Variant.ofX180(path), Face.CEILING, Facing.SOUTH, Powered.FALSE),
                ConditionalVariant.of(Variant.ofX180(this.pressedModel(path)), Face.CEILING, Facing.SOUTH, Powered.TRUE),
                ConditionalVariant.of(Variant.ofX180Y90(path), Face.CEILING, Facing.WEST, Powered.FALSE),
                ConditionalVariant.of(Variant.ofX180Y90(this.pressedModel(path)), Face.CEILING, Facing.WEST, Powered.TRUE),
                ConditionalVariant.of(Variant.ofY90(path), Face.FLOOR, Facing.EAST, Powered.FALSE),
                ConditionalVariant.of(Variant.ofY90(this.pressedModel(path)), Face.FLOOR, Facing.EAST, Powered.FALSE),
                ConditionalVariant.of(Variant.ofModel(path), Face.FLOOR, Facing.NORTH, Powered.FALSE),
                ConditionalVariant.of(Variant.ofModel(this.pressedModel(path)), Face.FLOOR, Facing.NORTH, Powered.FALSE),
                ConditionalVariant.of(Variant.ofY180(path), Face.FLOOR, Facing.SOUTH, Powered.FALSE),
                ConditionalVariant.of(Variant.ofY180(this.pressedModel(path)), Face.FLOOR, Facing.SOUTH, Powered.FALSE),
                ConditionalVariant.of(Variant.ofY270(path), Face.FLOOR, Facing.WEST, Powered.FALSE),
                ConditionalVariant.of(Variant.ofY270(this.pressedModel(path)), Face.FLOOR, Facing.WEST, Powered.FALSE),
                ConditionalVariant.of(Variant.ofUvlockX90Y90(path), Face.WALL, Facing.EAST, Powered.FALSE),
                ConditionalVariant.of(Variant.ofUvlockX90Y90(this.pressedModel(path)), Face.WALL, Facing.EAST, Powered.FALSE),
                ConditionalVariant.of(Variant.ofUvlockX90(path), Face.WALL, Facing.NORTH, Powered.FALSE),
                ConditionalVariant.of(Variant.ofUvlockX90(this.pressedModel(path)), Face.WALL, Facing.NORTH, Powered.FALSE),
                ConditionalVariant.of(Variant.ofUvlockX90Y180(path), Face.WALL, Facing.SOUTH, Powered.FALSE),
                ConditionalVariant.of(Variant.ofUvlockX90Y180(this.pressedModel(path)), Face.WALL, Facing.SOUTH, Powered.FALSE),
                ConditionalVariant.of(Variant.ofUvlockX90Y270(path), Face.WALL, Facing.WEST, Powered.FALSE),
                ConditionalVariant.of(Variant.ofUvlockX90Y270(this.pressedModel(path)), Face.WALL, Facing.WEST, Powered.FALSE)
        );
    }

    private String pressedModel(String path) {
        return StringUtils.joinWithUnderscore(path, PRESSED_SUFFIX);
    }

    private enum Face implements EnumBlockStateProperty {
        FLOOR, CEILING, WALL
    }
}