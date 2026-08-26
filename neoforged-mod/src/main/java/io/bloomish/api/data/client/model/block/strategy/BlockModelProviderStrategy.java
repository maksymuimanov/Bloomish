package io.bloomish.api.data.client.model.block.strategy;

import io.bloomish.api.data.client.model.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.block.spec.BlockModelSpec;

public interface BlockModelProviderStrategy<T extends BlockModelSpec> {
    void registerBlockModel(T spec, ApiBlockModelProvider provider);
}
