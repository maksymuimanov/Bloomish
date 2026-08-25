package io.bloomish.api.engine.metadata.strategy.field.data.loot;

import io.bloomish.api.engine.event.data.server.loot.BlockLootTableContainer;
import io.bloomish.api.engine.event.data.server.loot.spec.BlockLootTableSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.loot.GenerateDoorBlockLootTable;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateDoorBlockLootTableStrategy implements FieldAnnotationStrategy<GenerateDoorBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GenerateDoorBlockLootTable annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        BlockLootTableSpec spec = new BlockLootTableSpec(holder);
        BlockLootTableContainer.DOORS.add(spec);
    }

    @Override
    public Class<GenerateDoorBlockLootTable> getAnnotationClass() {
        return GenerateDoorBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
