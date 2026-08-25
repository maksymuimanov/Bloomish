package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class PlacementModifierTypeFactory extends AbstractObjectFactory<PlacementModifierType<?>> {
    public PlacementModifierTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$PlacementModifierTypes"));
    }

    public PlacementModifierTypeFactory(BloomishRegister<PlacementModifierType<?>> register) {
        super(register);
    }

    public <T extends PlacementModifier> DeferredHolder<PlacementModifierType<?>, PlacementModifierType<T>> create(String name, MapCodec<T> mapCodec) {
        return this.create(name, () -> () -> mapCodec);
    }
}
