package io.bloomish.api.engine.metadata.strategy.field.event.fml;

import io.bloomish.api.engine.event.handler.FMLClientSetupEventHandler;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.event.fml.SetupCrossbow;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.FMLClientSetupEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_FML)
public class SetupCrossbowStrategy implements FieldAnnotationStrategy<SetupCrossbow> {
    @Override
    public void execute(Field field, Object object, SetupCrossbow annotation) throws Exception {
        Holder<? extends Item> crossbow = ReflectionUtils.getFieldValue(field, object);
        FMLClientSetupEventHandler.CROSSBOWS.add(crossbow);
    }

    @Override
    public Class<SetupCrossbow> getAnnotationClass() {
        return SetupCrossbow.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(FMLClientSetupEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
