package io.bloomish.example.event.handler;

import io.bloomish.api.engine.event.handler.EventHandler;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;

@Handler(FMLLoadCompleteEvent.class)
public class ExampleLoadCompleteEventHandler implements EventHandler {
    @Override
    public void handle() {
        this.subscribeModEvent(FMLLoadCompleteEvent.class, event -> {
            System.out.println("Load has been completed");
        });
    }
}
