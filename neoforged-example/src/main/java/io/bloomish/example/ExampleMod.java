package io.bloomish.example;

import io.bloomish.api.ApiMod;
import io.bloomish.api.compat.AsyncDependencyFlowBuilder;
import io.bloomish.api.compat.SimpleDependencyFlowBuilder;
import io.bloomish.api.engine.BloomishEngine;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(ExampleMod.MOD_ID)
public class ExampleMod {
    public static final String MOD_ID = "example";

    public ExampleMod(IEventBus modEventBus, ModContainer modContainer) {
        BloomishEngine.run(ExampleMod.class, modEventBus, modContainer);
        //If there is a mod with "bloomish" mod id, it will log "hello", "world :D"
        SimpleDependencyFlowBuilder.ofDependencies("bloomish")
                .onDependency(() -> ApiMod.LOGGER.info("hello"))
                .onDependency(() -> ApiMod.LOGGER.info("world :D"))
                .build();
        //If there is a mod with "bloomish" mod id, it will log "1", "2", ... in different threads
        AsyncDependencyFlowBuilder.ofDependencies("bloomish")
                .onDependency(() -> ApiMod.LOGGER.info("I am async: 1"))
                .onDependency(() -> ApiMod.LOGGER.info("I am async: 2"))
                .onDependency(() -> ApiMod.LOGGER.info("I am async: 3"))
                .onDependency(() -> ApiMod.LOGGER.info("I am async: 4"))
                .onDependency(() -> ApiMod.LOGGER.info("I am async: 5"))
                .onDependency(() -> ApiMod.LOGGER.info("I am async: 6"))
                .onDependency(() -> ApiMod.LOGGER.info("I am async: 7"))
                .onDependency(() -> ApiMod.LOGGER.info("I am async: 8"))
                .onDependency(() -> ApiMod.LOGGER.info("I am async: 9"))
                .onDependency(() -> ApiMod.LOGGER.info("I am async: 10"))
                .build();
    }
}
