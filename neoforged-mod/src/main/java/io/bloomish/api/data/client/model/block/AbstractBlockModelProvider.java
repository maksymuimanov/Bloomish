package io.bloomish.api.data.client.model.block;

import io.bloomish.api.data.client.model.AbstractModelProvider;
import io.bloomish.api.data.client.model.block.model.BlockModel;
import io.bloomish.api.util.RegistryPathUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

public abstract class AbstractBlockModelProvider extends AbstractModelProvider<BlockModel> {
    protected static final String BLOCK_PATH = "block";

    protected AbstractBlockModelProvider(PackOutput packOutput) {
        super(packOutput);
    }

    protected void addBlockModel(Block block, BlockModel blockModel) {
        this.addBlockModel(block, blockModel, "");
    }

    protected void addBlockModel(Block block, BlockModel blockModel, String suffix) {
        this.addModel(RegistryPathUtils.findBlockPath(block), blockModel, BLOCK_PATH, suffix);
    }
}
