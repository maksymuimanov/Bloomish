package io.bloomish.api.data.client.model.deprecated.block;

import io.bloomish.api.data.client.model.deprecated.block.spec.BlockModelSpec;
import io.bloomish.api.data.client.model.deprecated.block.strategy.BlockModelProviderStrategy;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface BlockModelProviderStrategyConsumer {
    void registerModels(@NotNull ApiBlockModelProvider provider);

    <T extends BlockModelSpec> Consumer<T> registerBlockModel(@NotNull ApiBlockModelProvider provider, @NotNull Supplier<BlockModelProviderStrategy<T>> blockModelProviderStrategy);
}
