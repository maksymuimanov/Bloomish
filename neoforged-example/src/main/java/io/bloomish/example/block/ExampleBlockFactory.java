package io.bloomish.example.block;

import io.bloomish.api.bean.Injected;
import io.bloomish.api.engine.registry.extension.block.*;
import io.bloomish.api.engine.registry.factory.BlockFactory;

@Injected
public final class ExampleBlockFactory extends BlockFactory implements FlowerSubFactory,
        LeavesSubFactory, LogSubFactory, SaplingSubFactory,
        SlabSubFactory, StairSubFactory,
        ButtonSubFactory, PressurePlateSubFactory,
        FenceSubFactory, FenceGateSubFactory,
        DoorSubFactory, TrapDoorSubFactory,
        SignSubFactory, HangingSignSubFactory {
}