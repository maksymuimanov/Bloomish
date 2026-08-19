package io.bloomish.api.engine;

public interface LayerCustomizer<L extends EngineLayer> {
    void customize(L layer);
}
