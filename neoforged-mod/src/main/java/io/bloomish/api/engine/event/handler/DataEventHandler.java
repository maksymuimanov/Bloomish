package io.bloomish.api.engine.event.handler;

import io.bloomish.api.engine.event.data.DataGatherer;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Injected
@Handler(GatherDataEvent.class)
public class DataEventHandler implements EventHandler {
    private final DataGatherer dataGatherer;

    public DataEventHandler(DataGatherer dataGatherer) {
        this.dataGatherer = dataGatherer;
    }

    @Override
    public void handle() {
        this.subscribeModEvent(GatherDataEvent.class, this.dataGatherer::gatherData);
    }
}
