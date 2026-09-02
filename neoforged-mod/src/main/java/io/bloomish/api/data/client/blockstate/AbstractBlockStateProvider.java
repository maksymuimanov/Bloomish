package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.data.AbstractMultiDataProvider;
import io.bloomish.api.data.DataTarget;
import io.bloomish.api.data.client.ClientDataProvider;
import io.bloomish.api.util.RegistryPathUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

public abstract class AbstractBlockStateProvider extends AbstractMultiDataProvider implements ClientDataProvider {
    protected static final String STATES_PATH = "blockstates";

    protected AbstractBlockStateProvider(PackOutput packOutput) {
        super(packOutput);
    }

    protected void addBlockState(Block block, BlockState blockState) {
        String blockPath = RegistryPathUtils.findBlockPath(block);
        DataTarget dataTarget = DataTarget.createModAsset(STATES_PATH, blockPath);
        this.addData(dataTarget, blockState);
    }

    protected String blockPath(Block block) {
        return RegistryPathUtils.findBlockPath(block);
    }
}
