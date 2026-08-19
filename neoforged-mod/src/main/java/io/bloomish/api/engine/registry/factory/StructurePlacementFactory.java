package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class StructurePlacementFactory extends AbstractObjectFactory<StructurePlacementType<?>> {
    public StructurePlacementFactory() {
        this(DefaultObjectRegistry.getFromInstance("$StructurePlacements"));
    }

    public StructurePlacementFactory(TemporalRegister<StructurePlacementType<?>> register) {
        super(register);
    }

    public <T extends StructurePlacement> DeferredHolder<StructurePlacementType<?>, StructurePlacementType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
