package io.bloomish.api.engine.metadata.strategy.field.data.loot;

import io.bloomish.api.engine.event.data.loot.BlockLootTableContainer;
import io.bloomish.api.engine.event.data.loot.spec.BlockLootTableSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.loot.GeneratePottedContentBlockLootTable;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GeneratePottedContentBlockLootTableStrategy implements FieldAnnotationStrategy<GeneratePottedContentBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GeneratePottedContentBlockLootTable annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        BlockLootTableSpec spec = new BlockLootTableSpec(holder);
        BlockLootTableContainer.POTTED_CONTENTS.add(spec);
    }

    @Override
    public Class<GeneratePottedContentBlockLootTable> getAnnotationClass() {
        return GeneratePottedContentBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
