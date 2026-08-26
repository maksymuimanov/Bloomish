package io.bloomish.api.engine.metadata.strategy.type.data.tag;

import io.bloomish.api.data.preparer.tag.BiomeTagDynamicPreparer;
import io.bloomish.api.data.preparer.tag.BlockTagDynamicPreparer;
import io.bloomish.api.data.preparer.tag.EnchantmentTagDynamicPreparer;
import io.bloomish.api.data.preparer.tag.ItemTagDynamicPreparer;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.tag.AddTagContainer;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.type.ClassAnnotationStrategy;

@Strategy(StrategyInitializer.DEFAULT_CLASS_DATA)
public class AddTagContainerStrategy implements ClassAnnotationStrategy<AddTagContainer> {
    @Override
    public void execute(Class<?> clazz, Object object, AddTagContainer annotation) throws Exception {
        switch (annotation.value()) {
            case ITEM -> ItemTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case BLOCK -> BlockTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case BIOME -> BiomeTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
            case ENCHANTMENT -> EnchantmentTagDynamicPreparer.TAG_CONTAINERS.add(clazz);
        }
    }

    @Override
    public Class<AddTagContainer> getAnnotationClass() {
        return AddTagContainer.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
