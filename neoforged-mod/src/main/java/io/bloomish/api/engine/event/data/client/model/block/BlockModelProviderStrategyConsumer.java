package io.bloomish.api.engine.event.data.client.model.block;

import io.bloomish.api.engine.event.data.client.model.block.spec.BlockModelSpec;
import io.bloomish.api.engine.event.data.client.model.block.strategy.BlockModelProviderStrategy;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface BlockModelProviderStrategyConsumer {
    void registerModels(@NotNull ApiBlockModelProvider provider);

    <T extends BlockModelSpec> Consumer<T> registerBlockModel(@NotNull ApiBlockModelProvider provider, @NotNull Supplier<BlockModelProviderStrategy<T>> blockModelProviderStrategy);
}
