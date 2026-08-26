package io.bloomish.api.engine.metadata.strategy.field.data.loot;

import io.bloomish.api.data.server.loot.BlockLootTableContainer;
import io.bloomish.api.data.server.loot.spec.BlockLootTableSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.loot.GenerateShearsOnlyBlockLootTable;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateShearsOnlyBlockLootTableStrategy implements FieldAnnotationStrategy<GenerateShearsOnlyBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GenerateShearsOnlyBlockLootTable annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        BlockLootTableSpec spec = new BlockLootTableSpec(holder);
        BlockLootTableContainer.SHEARS_ONLY.add(spec);
    }

    @Override
    public Class<GenerateShearsOnlyBlockLootTable> getAnnotationClass() {
        return GenerateShearsOnlyBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
