package io.bloomish.api.engine.metadata.strategy.field.event.fml;

import io.bloomish.api.engine.event.handler.FMLClientSetupEventHandler;
import io.bloomish.api.engine.event.handler.FovModifierEventHandler;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.event.fml.SetupBow;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.FMLClientSetupEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_FML)
public class SetupBowStrategy implements FieldAnnotationStrategy<SetupBow> {
    @Override
    public void execute(Field field, Object object, SetupBow annotation) throws Exception {
        Holder<? extends Item> bow = ReflectionUtils.getFieldValue(field, object);
        FovModifierEventHandler.BOWS.add(bow);
        FMLClientSetupEventHandler.BOWS.add(bow);
    }

    @Override
    public Class<SetupBow> getAnnotationClass() {
        return SetupBow.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(FMLClientSetupEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
