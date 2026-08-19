package io.bloomish.api.engine.finalization;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.finalization.cleaner.ObjectPoolCleaner;

import java.util.List;

public class FinalizationLayer implements EngineLayer {
    private List<ObjectPoolCleaner> cleaners;

    @Override
    public void processAllTasks() {
        ApiMod.LOGGER.debug("Running {} ObjectPoolCleaners", cleaners.size());
        cleaners.forEach(ObjectPoolCleaner::clear);
        ApiMod.LOGGER.debug("Running dynamic ObjectPoolCleaners from pool");
        ObjectRegistry objectRegistry = DefaultObjectRegistry.getInstance();
        objectRegistry.getAll(ObjectPoolCleaner.class)
                .forEach(ObjectPoolCleaner::clear);
    }

    public void setCleaners(List<ObjectPoolCleaner> cleaners) {
        this.cleaners = cleaners;
    }
}
