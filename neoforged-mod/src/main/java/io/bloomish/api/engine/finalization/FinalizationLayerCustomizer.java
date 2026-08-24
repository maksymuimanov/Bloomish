package io.bloomish.api.engine.finalization;

import io.bloomish.api.engine.LayerCustomizer;

import java.util.List;

public class FinalizationLayerCustomizer implements LayerCustomizer<FinalizationLayer> {
    private static final List<ObjectPoolCleaner> DEFAULT_CLEANERS = List.of();
    private List<ObjectPoolCleaner> cleaners;

    public FinalizationLayerCustomizer() {
        this.cleaners = DEFAULT_CLEANERS;
    }

    public FinalizationLayerCustomizer cleaners(List<ObjectPoolCleaner> cleaners) {
        this.cleaners = cleaners;
        return this;
    }

    @Override
    public void customize(FinalizationLayer layer) {
        layer.setCleaners(cleaners);
    }
}
