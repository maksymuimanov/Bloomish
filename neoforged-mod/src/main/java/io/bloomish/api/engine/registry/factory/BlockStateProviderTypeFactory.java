package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockStateProviderTypeFactory extends AbstractObjectFactory<BlockStateProviderType<?>> {
    public BlockStateProviderTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$BlockstateProviderTypes"));
    }

    public BlockStateProviderTypeFactory(TemporalRegister<BlockStateProviderType<?>> register) {
        super(register);
    }

    public <T extends BlockStateProvider> DeferredHolder<BlockStateProviderType<?>, BlockStateProviderType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> new BlockStateProviderType<>(mapCodec));
    }
}
