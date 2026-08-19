package io.bloomish.api.engine.metadata.strategy.field.data.biome;

import io.bloomish.api.engine.event.data.biome.GenerationDescriptionContainer;
import io.bloomish.api.engine.event.data.biome.dto.Tree;
import io.bloomish.api.engine.event.data.preparer.tag.BiomeTagDynamicPreparer;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.biome.GenerateTree;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import io.bloomish.api.util.ResourceUtils;
import io.bloomish.api.util.TagUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateTreeStrategy implements FieldAnnotationStrategy<GenerateTree> {
    @Override
    public void execute(Field field, Object object, GenerateTree annotation) throws Exception {
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = ReflectionUtils.getFieldValue(field, object);
        var annotationConfiguration = annotation.configuration();
        var annotationPlacement = annotation.placement();
        var annotationBiomeModifier = annotation.biomeModifier();
        TagUtils.putTagContainer(BiomeTagDynamicPreparer.TAG_CONTAINERS, annotationBiomeModifier.biomeTagContainer());
        var configuration = this.getTreeConfiguration(annotationConfiguration);
        var placement = new Tree.Placement(annotationPlacement.sapling(), annotationPlacement.baseValue(), annotationPlacement.chance(), annotationPlacement.addedAmount());
        var biomeModifier = new Tree.BiomeModifier(annotationBiomeModifier.biomeTag());
        Tree tree = new Tree(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.TREES.put(configuredFeatureKey, tree);
    }

    private Tree.Configuration getTreeConfiguration(GenerateTree.Configuration annotationConfiguration) {
        GenerateTree.Trunk trunk = annotationConfiguration.trunk();
        GenerateTree.Foliage foliage = annotationConfiguration.foliage();
        GenerateTree.FeatureSize featureSize = annotationConfiguration.featureSize();
        return new Tree.Configuration(annotationConfiguration.log(), annotationConfiguration.leaves(), annotationConfiguration.root(),
                trunk.trunkPlacerClass(), trunk.baseHeight(), trunk.heightRandA(), trunk.heightRandB(),
                foliage.foliagePlacerClass(), foliage.radius(), foliage.offset(), foliage.height(),
                featureSize.type(), featureSize.limit(), featureSize.upperLimit(),
                featureSize.lowerSize(), featureSize.middleSize(), featureSize.upperSize(), featureSize.minClippedHeight(),
                annotationConfiguration.ignoreVines());
    }

    @Override
    public Class<GenerateTree> getAnnotationClass() {
        return GenerateTree.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
