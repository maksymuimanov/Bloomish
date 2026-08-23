package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.ModContext;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class WoodTypeFactory {
    private WoodTypeFactory() {
    }

    public static WoodType create(String name, BlockSetType setType, SoundType soundType, SoundType hangingSignSoundType, SoundEvent fenceGateClose, SoundEvent fenceGateOpen) {
        return WoodType.register(new WoodType(ModContext.currentMod.getModId() + ":" + name, setType, soundType, hangingSignSoundType, fenceGateClose, fenceGateOpen));
    }

    public static WoodType create(String name, BlockSetType setType) {
        return WoodType.register(new WoodType(ModContext.currentMod.getModId() + ":" + name, setType));
    }
}
