package io.bloomish.api.engine.metadata.strategy.field.data.tag;

import io.bloomish.api.engine.event.data.tag.EnchantmentTagsProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.tag.AddEnchantmentTag;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class AddEnchantmentTagStrategy implements FieldAnnotationStrategy<AddEnchantmentTag> {
    @Override
    public void execute(Field field, Object object, AddEnchantmentTag annotation) throws Exception {
        ResourceKey<Enchantment> enchantment = ReflectionUtils.getFieldValue(field, object);
        for (String tag : annotation.value()) {
            MapUtils.putToListMap(EnchantmentTagsProvider.TAG_GENERATION_DESCRIPTIONS, tag, enchantment);
        }
    }

    @Override
    public Class<AddEnchantmentTag> getAnnotationClass() {
        return AddEnchantmentTag.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
