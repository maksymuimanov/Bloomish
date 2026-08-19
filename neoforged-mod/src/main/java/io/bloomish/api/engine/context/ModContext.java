package io.bloomish.api.engine.context;

import io.bloomish.api.exception.PoolCreationException;
import io.bloomish.api.exception.PoolDeletionException;
import io.bloomish.api.exception.PoolGettingException;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class ModContext implements Context<String, InjectionPool> {
    public static volatile NeoMod NEO_MOD;
    public static final Set<Class<?>> ALL_CLASSES = new LinkedHashSet<>();
    private static volatile ModContext instance;
    private final Map<NeoMod, InjectionPool> injectionPools = new HashMap<>();

    private ModContext() {
    }

    @Override
    public InjectionPool getPool(String modId) {
        NeoMod mod = injectionPools.keySet()
                .stream()
                .filter(m -> m.getModId().equals(modId))
                .findAny()
                .orElseThrow(() -> new PoolGettingException("Could not find pool for modId: " + modId));
        return injectionPools.get(mod);
    }

    @Override
    public InjectionPool createPool(String modId) {
        boolean isModRegistered = injectionPools.keySet()
                .stream()
                .anyMatch(mod -> mod.getModId().equals(modId));
        if (isModRegistered)
            throw new PoolCreationException("Pool already exists!");
        injectionPools.put(NEO_MOD, new InjectionPool());
        return this.getPool(modId);
    }

    @Override
    public void removePool(String modId) {
        injectionPools.keySet()
                .stream()
                .filter(mod -> mod.getModId().equals(modId))
                .findAny()
                .ifPresentOrElse(injectionPools::remove, () -> {
                    throw new PoolDeletionException("Pool does not exist!");
                });
    }

    public static ModContext getInstance() {
        if (instance == null) {
            synchronized (ModContext.class) {
                if (instance == null) {
                    instance = new ModContext();
                }
            }
        }
        return instance;
    }
}
