package io.bloomish.api.data.client.model.block;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.model.block.model.BlockModel;
import io.bloomish.api.data.client.model.block.model.TexturedBlockModel;
import io.bloomish.api.data.client.model.block.texture.BlockTexture;
import io.bloomish.api.data.client.model.block.texture.DefaultBlockTexture;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.ResourceLocationUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

@Injected
public class ButtonBlockModelProvider extends AbstractBlockModelProvider {
    private static final String BUTTON_PATH = "button";
    private final ValueChannelBus channelBus;

    public ButtonBlockModelProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<BlockHolder>forEachDrain(DataChannels.BLOCK_MODEL_PROVIDER_BUTTON_BLOCKS, blockHolder -> {
            Block block = blockHolder.value();
            String parent = ResourceLocationUtils.joinMinecraftPath(BLOCK_PATH, BUTTON_PATH);
            BlockTexture blockTexture = this.resolveBlockTexture(blockHolder);
            BlockModel blockModel = TexturedBlockModel.of(parent, blockTexture);
            this.addBlockModel(block, blockModel);
        });
    }

    private BlockTexture resolveBlockTexture(BlockHolder blockHolder) {
        return blockHolder.texture()
                .map(DefaultBlockTexture::ofFullPath)
                .orElseGet(() -> DefaultBlockTexture.ofBlock(blockHolder.value()));
    }

    public record BlockHolder(
            Holder<? extends Block> block,
            Optional<String> texture
    ) {
        private Block value() {
            return block.value();
        }
    }
}
