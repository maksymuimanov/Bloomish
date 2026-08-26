package io.bloomish.api.engine.metadata.strategy.field.data.loot;

import io.bloomish.api.data.server.loot.BlockLootTableContainer;
import io.bloomish.api.data.server.loot.spec.MultipleOreBlockLootTableSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.loot.GenerateMultipleOreBlockLootTable;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateMultipleOreBlockLootTableStrategy implements FieldAnnotationStrategy<GenerateMultipleOreBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GenerateMultipleOreBlockLootTable annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        MultipleOreBlockLootTableSpec spec = new MultipleOreBlockLootTableSpec(holder, annotation.rawOre(), annotation.min(), annotation.max());
        BlockLootTableContainer.MULTIPLE_ORES.add(spec);
    }

    @Override
    public Class<GenerateMultipleOreBlockLootTable> getAnnotationClass() {
        return GenerateMultipleOreBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
