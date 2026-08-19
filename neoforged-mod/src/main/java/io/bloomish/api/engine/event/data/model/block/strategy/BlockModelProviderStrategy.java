package io.bloomish.api.engine.event.data.model.block.strategy;

import io.bloomish.api.engine.event.data.model.block.ApiBlockModelProvider;
import io.bloomish.api.engine.event.data.model.block.spec.BlockModelSpec;

public interface BlockModelProviderStrategy<T extends BlockModelSpec> {
    void registerBlockModel(T spec, ApiBlockModelProvider provider);
}
