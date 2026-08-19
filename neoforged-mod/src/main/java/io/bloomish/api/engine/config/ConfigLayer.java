package io.bloomish.api.engine.config;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.engine.config.screen.ConfigShowcaser;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.metadata.processor.AnnotationProcessor;
import io.bloomish.api.engine.metadata.processor.ConfigAnnotationProcessor;

import java.util.List;

public class ConfigLayer implements EngineLayer {
    private static final AnnotationProcessor CONFIG_PROCESSOR = new ConfigAnnotationProcessor();
    private List<ConfigShowcaser> configShowcasers;

    @Override
    public void processAllTasks() {
        ApiMod.LOGGER.debug("Processing ConfigAnnotationProcessor");
        CONFIG_PROCESSOR.process();
        this.configShowcasers.forEach(configShowcaser -> {
            ApiMod.LOGGER.debug("Running defaulted ConfigShowcaser - {}", configShowcaser.getClass().getName());
            configShowcaser.showcase();
        });
        ObjectRegistry objectRegistry = DefaultObjectRegistry.getInstance();
        objectRegistry.getAll(ConfigShowcaser.class).forEach(configShowcaser -> {
            ApiMod.LOGGER.debug("Running dynamic ConfigShowcaser - {}", configShowcaser.getClass().getName());
            configShowcaser.showcase();
        });
    }

    public void setConfigShowcasers(List<ConfigShowcaser> configShowcasers) {
        this.configShowcasers = configShowcasers;
    }
}
