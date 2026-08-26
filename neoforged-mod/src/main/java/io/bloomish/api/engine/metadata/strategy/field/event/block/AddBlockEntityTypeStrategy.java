package io.bloomish.api.engine.metadata.strategy.field.event.block;

import io.bloomish.api.engine.event.handler.BlockEntityTypeEventHandler;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.event.block.AddBlockEntityType;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.BlockEntityTypeEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.DeprecatedRegistryUtils;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_EVENT_BLOCK)
public class AddBlockEntityTypeStrategy implements FieldAnnotationStrategy<AddBlockEntityType> {
    @Override
    public void execute(Field field, Object object, AddBlockEntityType annotation) throws Exception {
        Holder<Block> block = ReflectionUtils.getFieldValue(field, object);
        BlockEntityType<?> blockEntityType = DeprecatedRegistryUtils.getBlockEntityType(annotation.value());
        MapUtils.putToListMap(BlockEntityTypeEventHandler.BLOCKS, blockEntityType, block);
    }

    @Override
    public Class<AddBlockEntityType> getAnnotationClass() {
        return AddBlockEntityType.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(BlockEntityTypeEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
