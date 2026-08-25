package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class StructurePieceFactory extends AbstractObjectFactory<StructurePieceType> {
    public StructurePieceFactory() {
        this(DefaultObjectRegistry.getFromInstance("$StructurePieces"));
    }

    public StructurePieceFactory(BloomishRegister<StructurePieceType> register) {
        super(register);
    }
}
