package io.bloomish.api.engine.event.handler;

import io.bloomish.api.engine.event.data.DataGatherer;
import io.bloomish.api.engine.event.subscriber.ModEventBusSubscriber;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Injected
public class DataEventHandler extends AbstractEventHandler<GatherDataEvent> {
    private final DataGatherer dataGatherer;

    public DataEventHandler(ModEventBusSubscriber eventBusSubscriber, DataGatherer dataGatherer) {
        super(eventBusSubscriber);
        this.dataGatherer = dataGatherer;
    }

    @Override
    protected void handle(GatherDataEvent event) {
        this.dataGatherer.gatherData(event);
    }
}
