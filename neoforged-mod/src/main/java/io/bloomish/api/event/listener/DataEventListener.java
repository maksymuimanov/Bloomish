package io.bloomish.api.event.listener;

import io.bloomish.api.data.DataGatherer;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventListener
public class DataEventListener {
    private final DataGatherer dataGatherer;

    public DataEventListener(DataGatherer dataGatherer) {
        this.dataGatherer = dataGatherer;
    }

    public void listen(GatherDataEvent event) {
        this.dataGatherer.gatherData(event);
    }
}
