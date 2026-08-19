package io.bloomish.api.engine.metadata.strategy.field.event.fml;

import io.bloomish.api.engine.event.handler.FMLClientSetupEventHandler;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.event.fml.SetupInstrument;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.FMLClientSetupEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_EVENT_FML)
public class SetupInstrumentStrategy implements FieldAnnotationStrategy<SetupInstrument> {
    @Override
    public void execute(Field field, Object object, SetupInstrument annotation) throws Exception {
        Holder<? extends Item> instrument = ReflectionUtils.getFieldValue(field, object);
        FMLClientSetupEventHandler.INSTRUMENTS.add(instrument);
    }

    @Override
    public Class<SetupInstrument> getAnnotationClass() {
        return SetupInstrument.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(FMLClientSetupEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
