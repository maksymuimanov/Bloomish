package io.bloomish.api.engine.context;

import java.util.*;

public final class EngineContext implements ModContext, ObjectRegistryContext<String>, ClassContext {
    private static volatile EngineContext instance;
    private final Map<NeoMod, ObjectRegistry> objectRegistries;
    private final Set<Class<?>> observedClasses;
    private volatile NeoMod currentMod;
    private volatile ObjectRegistry currentRegistry;

    private EngineContext() {
        this.objectRegistries = new HashMap<>();
        this.observedClasses = new LinkedHashSet<>();
    }

    public static String getModId() {
        return getInstance().getCurrentMod().modId();
    }

    public static Set<Class<?>> getModClasses() {
        return getInstance().getCurrentMod().classes();
    }

    public static <T> Collection<? extends T> getObjects(Class<T> commonInterface) {
        return getInstance().getCurrentRegistry().getAll(commonInterface);
    }

    public static <T> T getObject(Class<? extends T> clazz) {
        return getInstance().getCurrentRegistry().getByClass(clazz);
    }

    public static ObjectRegistry getRegistry() {
        return getInstance().getCurrentRegistry();
    }

    @Override
    public ObjectRegistry getCurrentRegistry() {
        return currentRegistry;
    }

    @Override
    public void setCurrentRegistry(ObjectRegistry registry) {
        this.currentRegistry = registry;
    }

    @Override
    public ObjectRegistry getRegistry(String modId) {
        NeoMod neoMod = objectRegistries.keySet()
                .stream()
                .filter(mod -> mod.matchesModId(modId))
                .findAny()
                .orElseThrow(() -> new ModContextException("Could not find pool for modId: " + modId));
        return objectRegistries.get(neoMod);
    }

    @Override
    public ObjectRegistry createRegistry(String modId) {
        boolean isModRegistered = objectRegistries.keySet()
                .stream()
                .anyMatch(mod -> mod.matchesModId(modId));
        if (isModRegistered)
            throw new ModContextException("Registry already exists!");
        objectRegistries.put(currentMod, new DefaultObjectRegistry());
        return this.getRegistry(modId);
    }

    @Override
    public void removeRegistry(String modId) {
        objectRegistries.keySet()
                .stream()
                .filter(mod -> mod.matchesModId(modId))
                .findAny()
                .ifPresentOrElse(objectRegistries::remove, () -> {
                    throw new ModContextException("Registry does not exist!");
                });
    }

    @Override
    public Collection<Class<?>> getAllClasses() {
        return Set.copyOf(observedClasses);
    }

    @Override
    public void addAllClasses(Collection<Class<?>> classes) {
        this.observedClasses.addAll(classes);
    }

    @Override
    public NeoMod getCurrentMod() {
        return currentMod;
    }

    @Override
    public void setCurrentMod(NeoMod mod) {
        this.currentMod = mod;
    }

    public static EngineContext getInstance() {
        if (instance == null) {
            synchronized (EngineContext.class) {
                if (instance == null) {
                    instance = new EngineContext();
                }
            }
        }
        return instance;
    }
}
