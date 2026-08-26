package io.bloomish.api.data.client.model.deprecated.block.strategy;

import io.bloomish.api.data.client.model.deprecated.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.deprecated.block.spec.BlockModelSpec;

public interface BlockModelProviderStrategy<T extends BlockModelSpec> {
    void registerBlockModel(T spec, ApiBlockModelProvider provider);
}
