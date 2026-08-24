package io.bloomish.api.engine.finalization;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.engine.context.ModContext;

import java.util.List;

public class FinalizationLayer implements EngineLayer {
    private List<ObjectPoolCleaner> cleaners;

    @Override
    public void process() {
        ApiMod.LOGGER.debug("Running {} ObjectPoolCleaners", cleaners.size());
        cleaners.forEach(ObjectPoolCleaner::clear);
        ApiMod.LOGGER.debug("Running dynamic ObjectPoolCleaners from pool");
        ModContext.forEachObject(ObjectPoolCleaner.class, ObjectPoolCleaner::clear);
    }

    void setCleaners(List<ObjectPoolCleaner> cleaners) {
        this.cleaners = cleaners;
    }
}
