package io.bloomish.api.engine.finalization;

import io.bloomish.api.ApiMod;
import io.bloomish.api.context.ModContext;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.finalization.ObjectRegistryCleaner;

public class FinalizationLayer implements EngineLayer {
    @Override
    public void process() {
        ApiMod.LOGGER.debug("Running FinalizationLayer");
        ModContext.forEachObject(ObjectRegistryCleaner.class, objectRegistryCleaner -> {
            ApiMod.LOGGER.debug("Running ObjectRegistryCleaner: {}", objectRegistryCleaner.getClass().getName());
            objectRegistryCleaner.clear();
        });
    }
}
