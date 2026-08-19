package io.bloomish.api.engine.event.handler;

import io.bloomish.api.engine.event.data.ApiDataGenerator;
import io.bloomish.api.engine.event.data.DataGatherer;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Handler(GatherDataEvent.class)
public class DataEventHandler implements EventHandler {
    private static final DataGatherer GENERATOR = new ApiDataGenerator();

    @Override
    public void handle() {
        this.subscribeModEvent(GatherDataEvent.class, GENERATOR::gatherData);
    }
}
