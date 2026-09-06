package io.bloomish.api.engine.config;

import io.bloomish.api.ApiMod;
import io.bloomish.api.config.screen.ConfigShowcaser;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.engine.metadata.processor.AnnotationProcessor;
import io.bloomish.api.engine.metadata.processor.ConfigAnnotationProcessor;

public class ConfigLayer implements EngineLayer {
    private static final AnnotationProcessor CONFIG_PROCESSOR = new ConfigAnnotationProcessor();

    @Override
    public void process() {
        ApiMod.LOGGER.debug("Processing ConfigAnnotationProcessor");
        CONFIG_PROCESSOR.process();
        this.runConfigShowcasers();
    }

    private void runConfigShowcasers() {
        ModContext.forEachObject(ConfigShowcaser.class, configShowcaser -> {
            ApiMod.LOGGER.debug("Running dynamic ConfigShowcaser - {}", configShowcaser.getClass().getName());
            configShowcaser.showcase();
        });
    }
}
