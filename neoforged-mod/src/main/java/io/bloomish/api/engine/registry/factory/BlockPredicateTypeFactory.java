package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicateType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockPredicateTypeFactory extends AbstractObjectFactory<BlockPredicateType<?>> {
    public BlockPredicateTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$BlockPredicateTypes"));
    }

    public BlockPredicateTypeFactory(BloomishRegister<BlockPredicateType<?>> register) {
        super(register);
    }

    public <T extends BlockPredicate> DeferredHolder<BlockPredicateType<?>, BlockPredicateType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
