package io.bloomish.api.engine.metadata.strategy.field.data;

import io.bloomish.api.data.server.enchantment.ApiEnchantmentProvider;
import io.bloomish.api.data.server.enchantment.EnchantmentDescription;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.GenerateEnchantment;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateEnchantmentStrategy implements FieldAnnotationStrategy<GenerateEnchantment> {
    @Override
    public void execute(Field field, Object object, GenerateEnchantment annotation) throws Exception {
        ResourceKey<Enchantment> enchantment = ReflectionUtils.getFieldValue(field, object);
        Constructor<?> constructor = annotation.value().getDeclaredConstructor();
        constructor.setAccessible(true);
        EnchantmentDescription descriptionHolder = (EnchantmentDescription) constructor.newInstance();
        ApiEnchantmentProvider.ENCHANTMENTS.put(enchantment, descriptionHolder);
    }

    @Override
    public Class<GenerateEnchantment> getAnnotationClass() {
        return GenerateEnchantment.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
