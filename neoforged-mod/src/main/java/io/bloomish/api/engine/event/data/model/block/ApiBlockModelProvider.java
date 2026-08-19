package io.bloomish.api.engine.event.data.model.block;

import io.bloomish.api.common.block.ApiCropBlock;
import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.engine.event.data.model.RenderTypes;
import io.bloomish.api.engine.event.data.model.block.spec.BlockModelSpec;
import io.bloomish.api.engine.event.data.model.block.spec.DependantBlockModelSpec;
import io.bloomish.api.util.ResourceUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class ApiBlockModelProvider extends BlockStateProvider {
    private static final BlockModelProviderStrategyConsumer CONSUMER = new BlockModelProviderStrategyConsumerImpl();

    public ApiBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModContext.NEO_MOD.getModId(), existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        CONSUMER.registerModels(this);
    }

    public <T extends Block> void otherBlockTexture(DependantBlockModelSpec spec, BiConsumer<T, ResourceLocation> blockModelRegistry) {
        T block = spec.getBlock();
        ResourceLocation dependencyTexture = spec.getDependencyLocation();
        blockModelRegistry.accept(block, dependencyTexture);
    }

    public void cropBlock(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    @SuppressWarnings("unchecked")
    public <T extends ApiCropBlock> ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        Integer age = state.getValue(((T) block).getAgeProperty());
        models[0] = new ConfiguredModel(models().crop(modelName + age, ResourceUtils.parse(BlockModelSpec.BLOCK_PREFIX + "/" + textureName + age)).renderType(RenderTypes.CUTOUT));
        return models;
    }
}
