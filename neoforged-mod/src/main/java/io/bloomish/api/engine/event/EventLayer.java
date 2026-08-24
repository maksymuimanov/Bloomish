package io.bloomish.api.engine.event;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.engine.context.ModContext;

public class EventLayer implements EngineLayer {
    @Override
    public void process() {
        ApiMod.LOGGER.debug("Processing dynamic event handlers");
        ModContext.forEachObject(EventHandler.class, eventHandler -> {
            ApiMod.LOGGER.debug("Processing dynamic eventHandler {}", eventHandler.getClass().getName());
            eventHandler.handle();
        });
    }
}
