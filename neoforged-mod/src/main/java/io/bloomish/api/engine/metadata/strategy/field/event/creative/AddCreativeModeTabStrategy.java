package io.bloomish.api.engine.metadata.strategy.field.event.creative;

import io.bloomish.api.engine.event.handler.CreativeModeTabEventHandler;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.event.creative.AddCreativeModeTab;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.constant.CreativeModeTabType;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.CreativeModeTabEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_EVENT_CREATIVE)
public class AddCreativeModeTabStrategy implements FieldAnnotationStrategy<AddCreativeModeTab> {
    @Override
    public void execute(Field field, Object object, AddCreativeModeTab annotation) throws Exception {
        Holder<? extends Item> item = ReflectionUtils.getItemHolder(field, object);
        CreativeModeTabType[] tabTypes = annotation.value();
        for (CreativeModeTabType tabType : tabTypes) {
            ResourceKey<CreativeModeTab> tab = tabType.getCreativeTab();
            MapUtils.putToListMap(CreativeModeTabEventHandler.CREATIVE_MODE_TABS_CONTENT, tab, item);
        }
    }

    @Override
    public Class<AddCreativeModeTab> getAnnotationClass() {
        return AddCreativeModeTab.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(CreativeModeTabEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
