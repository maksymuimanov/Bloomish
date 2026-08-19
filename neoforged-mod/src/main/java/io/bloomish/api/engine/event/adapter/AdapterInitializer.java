package io.bloomish.api.engine.event.adapter;

public interface AdapterInitializer {
    void initialize();

    void initialize(boolean condition);
}
