package io.bloomish.example.event.handler;

import io.bloomish.api.engine.event.EventHandler;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;

@Handler(FMLLoadCompleteEvent.class)
public class ExampleHelloWorldEventHandler implements EventHandler {
    @Override
    public void handle() {
        this.subscribeModEvent(FMLLoadCompleteEvent.class, event -> {
            System.out.println("Hello World!");
        }, EventPriority.HIGHEST);
    }
}
