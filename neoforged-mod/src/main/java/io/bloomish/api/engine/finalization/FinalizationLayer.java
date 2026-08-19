package io.bloomish.api.engine.finalization;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.context.ObjectPool;
import io.bloomish.api.engine.finalization.cleaner.ObjectPoolCleaner;

import java.util.List;

public class FinalizationLayer implements EngineLayer {
    private List<ObjectPoolCleaner> objectPoolCleaners;

    @Override
    public void processAllTasks() {
        ApiMod.LOGGER.debug("Running {} ObjectPoolCleaners", objectPoolCleaners.size());
        objectPoolCleaners.forEach(ObjectPoolCleaner::clear);
        ApiMod.LOGGER.debug("Running dynamic ObjectPoolCleaners from pool");
        ObjectPool objectPool = InjectionPool.getInstance();
        objectPool.getAll(ObjectPoolCleaner.class)
                .forEach(ObjectPoolCleaner::clear);
    }

    public void setContextCleaners(List<ObjectPoolCleaner> objectPoolCleaners) {
        this.objectPoolCleaners = objectPoolCleaners;
    }
}
