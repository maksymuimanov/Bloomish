package io.bloomish.api.engine.context;

import java.util.*;
import java.util.function.Consumer;

public final class ModContext implements ObjectRegistryContext<String>, NeoModContext, ClassContext {
    private static volatile ModContext instance;
    private final Map<NeoMod, ObjectRegistry> objectRegistries;
    private final Set<Class<?>> observedClasses;
    private volatile NeoMod currentMod;
    private volatile ObjectRegistry currentRegistry;

    private ModContext() {
        this.objectRegistries = new HashMap<>();
        this.observedClasses = new LinkedHashSet<>();
    }

    public static String getModId() {
        return getInstance().getNeoMod().modId();
    }

    public static Set<Class<?>> getModClasses() {
        return getInstance().getNeoMod().classes();
    }

    public static <T> void forEachObject(Class<T> commonInterface, Consumer<T> consumer) {
        getObjects(commonInterface).forEach(consumer);
    }

    public static <T> Collection<? extends T> getObjects(Class<T> commonInterface) {
        return getCurrentRegistry().getAll(commonInterface);
    }

    public static <T> T getObject(Class<? extends T> clazz) {
        return getCurrentRegistry().getByClass(clazz);
    }

    public static ObjectRegistry getCurrentRegistry() {
        return getInstance().getRegistry();
    }

    @Override
    public ObjectRegistry getRegistry() {
        return currentRegistry;
    }

    @Override
    public void setRegistry(ObjectRegistry registry) {
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
    public NeoMod getNeoMod() {
        return currentMod;
    }

    @Override
    public void setNeoMod(NeoMod neoMod) {
        this.currentMod = neoMod;
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
