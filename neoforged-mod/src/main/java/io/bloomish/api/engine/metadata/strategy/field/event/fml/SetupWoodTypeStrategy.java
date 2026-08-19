package io.bloomish.api.engine.metadata.strategy.field.event.fml;

import io.bloomish.api.engine.event.handler.FMLClientSetupEventHandler;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.event.fml.SetupWoodType;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.FMLClientSetupEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.core.util.ReflectionUtils;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_EVENT_FML)
public class SetupWoodTypeStrategy implements FieldAnnotationStrategy<SetupWoodType> {
    @Override
    public void execute(Field field, Object object, SetupWoodType annotation) throws Exception {
        WoodType woodType = ReflectionUtils.getFieldValue(field, object);
        FMLClientSetupEventHandler.WOOD_TYPES.add(woodType);
    }

    @Override
    public Class<SetupWoodType> getAnnotationClass() {
        return SetupWoodType.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(FMLClientSetupEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
