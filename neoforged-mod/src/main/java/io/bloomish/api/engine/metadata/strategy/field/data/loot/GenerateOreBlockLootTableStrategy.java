package io.bloomish.api.engine.metadata.strategy.field.data.loot;

import io.bloomish.api.engine.event.data.loot.BlockLootTableContainer;
import io.bloomish.api.engine.event.data.loot.spec.OtherItemBlockLootTableSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.loot.GenerateOreBlockLootTable;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateOreBlockLootTableStrategy implements FieldAnnotationStrategy<GenerateOreBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GenerateOreBlockLootTable annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        OtherItemBlockLootTableSpec spec = new OtherItemBlockLootTableSpec(holder, annotation.rawOre());
        BlockLootTableContainer.ORES.add(spec);
    }

    @Override
    public Class<GenerateOreBlockLootTable> getAnnotationClass() {
        return GenerateOreBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
