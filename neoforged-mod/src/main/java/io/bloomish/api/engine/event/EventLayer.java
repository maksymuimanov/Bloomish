package io.bloomish.api.engine.event;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.engine.event.pool.HandlerPool;
import io.bloomish.api.engine.event.pool.SimpleHandlerPool;

//TODO: Overall event handler needs to be reworked
public class EventLayer implements EngineLayer {
    @Override
    public void process() {
        HandlerPool handlerPool = SimpleHandlerPool.getInstance();
        ApiMod.LOGGER.debug("Processing dynamic {} eventClass handlers", handlerPool);
        handlerPool.forEach(eventHandler -> {
            ApiMod.LOGGER.debug("Processing dynamic eventHandler {}", eventHandler.getClass().getName());
            eventHandler.handle();
        });
    }
}
