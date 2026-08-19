package io.bloomish.api.engine;

import io.bloomish.api.ApiMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;

import java.util.List;

public class BloomishEngine {
    public static final String BANNER = """
             ________  ___       ________  ________  _____ ______   ___  ________  ___  ___    \s
            |\\   __  \\|\\  \\     |\\   __  \\|\\   __  \\|\\   _ \\  _   \\|\\  \\|\\   ____\\|\\  \\|\\  \\   \s
            \\ \\  \\|\\ /\\ \\  \\    \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\  \\ \\  \\___|\\ \\  \\\\\\  \\  \s
             \\ \\   __  \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\\\|__| \\  \\ \\  \\ \\_____  \\ \\   __  \\ \s
              \\ \\  \\|\\  \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\    \\ \\  \\ \\  \\|____|\\  \\ \\  \\ \\  \\\s
               \\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\__\\    \\ \\__\\ \\__\\____\\_\\  \\ \\__\\ \\__\\
                \\|_______|\\|_______|\\|_______|\\|_______|\\|__|     \\|__|\\|__|\\_________\\|__|\\|__|
                                                                           \\|_________|                                    v1.0.0
            """;

    private BloomishEngine() {
    }

    public static LayerContainer run(Class<?> modClass, IEventBus eventBus, ModContainer modContainer) {
        System.out.println(BANNER);
        ApiMod.LOGGER.info("Running BloomishEngine for : {}", modClass.getName());
        return defaultBuilder(modClass, eventBus, modContainer).build();
    }

    public static EngineBuilder defaultBuilder(Class<?> modClass, IEventBus eventBus, ModContainer modContainer) {
        return builder()
                .initializationLayer(customizer -> customizer
                        .modClass(modClass)
                        .externalSource(List.of(eventBus, modContainer)))
                .registryLayer()
                .metadataLayer()
                .configLayer()
                .eventLayer()
                .finalizationLayer();
    }

    public static EngineBuilder builder() {
        return new EngineBuilder();
    }
}
