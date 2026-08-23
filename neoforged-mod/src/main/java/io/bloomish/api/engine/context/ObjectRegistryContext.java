package io.bloomish.api.engine.context;

public interface ObjectRegistryContext<K> {
    ObjectRegistry getRegistry();

    void setRegistry(ObjectRegistry registry);

    ObjectRegistry getRegistry(K key);

    ObjectRegistry createRegistry(K key);

    void removeRegistry(K key);
}
