package io.bloomish.api.engine.metadata.strategy.type.injection;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.injection.RegisterConfig;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.ConfigAnnotationProcessor;
import io.bloomish.api.engine.metadata.strategy.type.ClassAnnotationStrategy;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Strategy(StrategyPoolInitializer.DEFAULT_CLASS_CONFIG)
public class RegisterConfigStrategy implements ClassAnnotationStrategy<RegisterConfig> {
    @Override
    public void execute(Class<?> clazz, Object object, RegisterConfig annotation) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor(ModConfigSpec.Builder.class);
        ModConfigSpec.Builder configSpecBuilder = new ModConfigSpec.Builder();
        Pair<?, ModConfigSpec> configuration = configSpecBuilder.configure(builder -> {
            try {
                Object instance = constructor.newInstance(builder);
                builder.build();
                return instance;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
        ModContainer modContainer = DefaultObjectRegistry.getFromInstance(ModContainer.class);
        modContainer.registerConfig(annotation.value(), configuration.getRight());
    }

    @Override
    public Class<RegisterConfig> getAnnotationClass() {
        return RegisterConfig.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(ConfigAnnotationProcessor.NAME);
    }
}
