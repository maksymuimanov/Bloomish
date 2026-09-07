package io.bloomish.api.engine.config;

import io.bloomish.api.ApiMod;
import io.bloomish.api.config.screen.ConfigShowcaser;
import io.bloomish.api.context.ModContext;
import io.bloomish.api.engine.EngineLayer;

public class ConfigLayer implements EngineLayer {
    @Override
    public void process() {
        ApiMod.LOGGER.debug("Processing ConfigAnnotationProcessor");
        ModContext.forEachObject(ConfigShowcaser.class, configShowcaser -> {
            ApiMod.LOGGER.debug("Running ConfigShowcaser: {}", configShowcaser.getClass().getName());
            configShowcaser.showcase();
        });
    }
}
