package io.bloomish.api.engine.context;

public interface ObjectRegistryContext<K> {
    ObjectRegistry getCurrentRegistry();

    void setCurrentRegistry(ObjectRegistry registry);

    ObjectRegistry getRegistry(K key);

    ObjectRegistry createRegistry(K key);

    void removeRegistry(K key);
}
