package io.bloomish.api.engine.metadata.strategy.field.data.loot;

import io.bloomish.api.data.server.loot.BlockLootTableContainer;
import io.bloomish.api.data.server.loot.spec.LeavesBlockLootTableSpec;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.loot.GenerateLeavesBlockLootTable;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateLeavesBlockLootTableStrategy implements FieldAnnotationStrategy<GenerateLeavesBlockLootTable> {
    @Override
    public void execute(Field field, Object object, GenerateLeavesBlockLootTable annotation) throws Exception {
        Holder<? extends Block> holder = ReflectionUtils.getFieldValue(field, object);
        List<Float> chances = new ArrayList<>();
        for (float chance : annotation.chances()) {
            chances.add(chance);
        }
        LeavesBlockLootTableSpec spec = new LeavesBlockLootTableSpec(holder, annotation.sapling(), chances);
        BlockLootTableContainer.LEAVES.add(spec);
    }

    @Override
    public Class<GenerateLeavesBlockLootTable> getAnnotationClass() {
        return GenerateLeavesBlockLootTable.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
