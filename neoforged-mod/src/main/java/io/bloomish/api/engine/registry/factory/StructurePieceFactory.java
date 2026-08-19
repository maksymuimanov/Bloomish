package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class StructurePieceFactory extends AbstractObjectFactory<StructurePieceType> {
    public StructurePieceFactory() {
        this(InjectionPool.getFromInstance("$StructurePieces"));
    }

    public StructurePieceFactory(TemporalRegister<StructurePieceType> register) {
        super(register);
    }
}
