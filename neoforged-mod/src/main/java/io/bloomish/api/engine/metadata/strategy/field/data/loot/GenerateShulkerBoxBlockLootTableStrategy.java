package io.bloomish.api.engine.metadata.strategy.field.data.loot;

import io.bloomish.api.data.server.loot.BlockLootTableContainer;
import io.bloomish.api.data.server.loot.spec.BlockLootTableSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.loot.GenerateShulkerBoxBlockLootTable;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateShulkerBoxBlockLootTableStrategy implements FieldAnnotationStrategy<GenerateShulkerBoxBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GenerateShulkerBoxBlockLootTable annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        BlockLootTableSpec spec = new BlockLootTableSpec(holder);
        BlockLootTableContainer.SHULKER_BOXES.add(spec);
    }

    @Override
    public Class<GenerateShulkerBoxBlockLootTable> getAnnotationClass() {
        return GenerateShulkerBoxBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
